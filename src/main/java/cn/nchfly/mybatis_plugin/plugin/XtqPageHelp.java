package cn.nchfly.mybatis_plugin.plugin;

import cn.nchfly.mybatis_plugin.domain.request.PageRequest;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Connection;
import java.util.Properties;

/**
 * @Author xtq
 * @Date 2020/4/7 23:01
 * @Description  自定义分页分页插件
 */

/**
 * 插件签名:
 * type：要拦截的对象
 * method：要拦截的方法
 * args：参数
 */
@Intercepts(
        @Signature(type = StatementHandler.class,method = "prepare",args = {Connection.class, Integer.class})
)
public class XtqPageHelp implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object target = invocation.getTarget();
        if(target instanceof StatementHandler){
            //获取拦截到的StatementHandler对象
            StatementHandler statementHandler = (StatementHandler) target;
            //拿到statementHandler的元数据
            MetaObject metaObject= SystemMetaObject.forObject(statementHandler);

            /**
             * 先解释下为什么写成delegate.boundSql就可以拿到boundSql类
             * 从前面也可以得知，statementHandler的默认实现是routingStatementHandler。
             * 这个类有一个属性statementHandler，属性名就叫delegate，
             * 而这个属性的默认实现又是preparedStatementHandler
             * 后面这个类又有属性boundSql，所以，最终形成的写法就是delegate.boundSql。
             * 所以这也体现了MetaObject工具类的强大，可以通过实例传参，就可以根据属性名获取对应属性值
             */
            //获取sql语句
            BoundSql boundSql=(BoundSql)metaObject.getValue("delegate.boundSql");
            String sql=boundSql.getSql();
            System.out.println("获取到的sql："+sql);
            //获取请求分页参数
            PageRequest pageRequest = (PageRequest) boundSql.getParameterObject();
            Long page = pageRequest.getPage();//当前页数
            Long size = pageRequest.getSize();//每页显示条数
            Long startIndex = (page-1)*size;//计算出开始索引位置
            //组装新的分页sql语句
            String pageSql = sql + " limit "+startIndex+","+size;
            metaObject.setValue("delegate.boundSql.sql", pageSql);

        }

        //调用下一个拦截器拦截目标方法。
        return invocation.proceed();
    }

    /**
     * 包装目标对象：
     * 为目标对象创建代理对象
     * @param target
     * @return
     */
    @Override
    public Object plugin(Object target) {
        if(target instanceof StatementHandler){
            //我们可以借助Plugin的wrap方法来使用当前Interceptor包装我们目标对象
            Object wrap = Plugin.wrap(target, this);
            //返回为当前target创建的动态代理
            return wrap;
        }
        return target;
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
