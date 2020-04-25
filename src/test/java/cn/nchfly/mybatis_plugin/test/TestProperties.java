package cn.nchfly.mybatis_plugin.test;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @Author xtq
 * @Date 2020/4/19 18:35
 * @Description
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestProperties {

    @Autowired
    private ProrpertiesTest prorpertiesTest;

    @Test
    public void testPropertiesSource(){
        System.out.println(prorpertiesTest);
    }
}
