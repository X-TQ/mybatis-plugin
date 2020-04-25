package cn.nchfly.mybatis_plugin.controller;

import cn.nchfly.mybatis_plugin.domain.request.PageRequest;
import cn.nchfly.mybatis_plugin.domain.response.PageResponse;
import cn.nchfly.mybatis_plugin.mapper.UserMapper;
import cn.nchfly.mybatis_plugin.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author xtq
 * @Date 2020/3/30 15:16
 * @Description
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/all")
    public List<User> userAll(){
        PageRequest<User> pageRequest = new PageRequest<>(2l,3l,null);
        List<User> list = userMapper.findAll(pageRequest);

        return list;
    }


}
