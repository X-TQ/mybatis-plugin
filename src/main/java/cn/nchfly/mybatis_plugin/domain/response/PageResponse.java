package cn.nchfly.mybatis_plugin.domain.response;

import cn.nchfly.mybatis_plugin.domain.request.PageRequest;

import java.util.List;

/**
 * @Author xtq
 * @Date 2020/4/8 10:04
 * @Description
 */

public class PageResponse<T> extends PageRequest {
    protected List<T> list;//用于封装结果集
    protected Long totalPage;//总页数
    protected Long totalSize;//总条数

    public PageResponse(){}

    public PageResponse(List<T> list, Long totalPage, Long totalSize) {
        this.list = list;
        this.totalPage = totalPage;
        this.totalSize = totalSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Long totalPage) {
        this.totalPage = totalPage;
    }

    public Long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Long totalSize) {
        this.totalSize = totalSize;
    }
}
