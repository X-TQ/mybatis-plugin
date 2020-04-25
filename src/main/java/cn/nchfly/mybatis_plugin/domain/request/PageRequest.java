package cn.nchfly.mybatis_plugin.domain.request;

/**
 * @Author xtq
 * @Date 2020/4/8 10:01
 * @Description 用于封装分页请求参数
 */

public class PageRequest<T> {

    protected Long page;//当前页数
    protected Long size;//每页显示条数
    protected T t;//封装请求参数的对象

    public PageRequest(){}

    public PageRequest(Long page, Long size, T t) {
        this.page = page;
        this.size = size;
        this.t = t;
    }

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
