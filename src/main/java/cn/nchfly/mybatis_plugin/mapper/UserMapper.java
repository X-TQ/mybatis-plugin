package cn.nchfly.mybatis_plugin.mapper;

import cn.nchfly.mybatis_plugin.domain.request.PageRequest;
import cn.nchfly.mybatis_plugin.domain.response.PageResponse;
import cn.nchfly.mybatis_plugin.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> findAll(PageRequest pageRequest);

}
