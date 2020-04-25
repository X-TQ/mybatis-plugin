package cn.nchfly.mybatis_plugin.config;

import cn.nchfly.mybatis_plugin.plugin.XtqPageHelp;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author xtq
 * @Date 2020/4/7 23:56
 * @Description
 */

@Configuration
public class MybatisConfig {

    /**
     * 方式一：直接注入
     * 注入插件到拦截链
     * 自定义的插件
     * @return
     */
    @Bean
    public XtqPageHelp xtqPageHelp(){
        XtqPageHelp xtqPageHelp = new XtqPageHelp();
        return xtqPageHelp;
    }

    /**
     * 方式二：通过myabtis配置加入到拦截链中
     * 注入插件到拦截链
     * @return
     */
    //@Bean
    public ConfigurationCustomizer configurationCustomizer(){
        return new ConfigurationCustomizer() {
            @Override
            public void customize(org.apache.ibatis.session.Configuration configuration) {
                configuration.setMapUnderscoreToCamelCase(true);//设置驼峰命名规则
                configuration.addInterceptor(xtqPageHelp());//配置自定义插件
            }
        };
    }
}
