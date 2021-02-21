package com.example.test;

import com.example.service.EmpService;
import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

/**
 * @Author: 刘欢
 * @Date: 2019/10/30 17:28
 */
public class Day07Test {

    ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
    @Test
    public void test1(){
        EmpService empService = context.getBean("empService", EmpService.class);
        List<Map<String, Object>> mapList = empService.queryEmpByRelative(null);
        for (Map<String, Object> map : mapList) {
            System.out.println(map);
        }
    }

    @Test
    public void test2(){
        EmpService empService = context.getBean("empService",EmpService.class);
        List<Map<String, Object>> mapList = empService.queryEmpByParams("男",null);
        for (Map<String, Object> stringObjectMap : mapList) {
            System.out.println(stringObjectMap);
        }
    }
}
