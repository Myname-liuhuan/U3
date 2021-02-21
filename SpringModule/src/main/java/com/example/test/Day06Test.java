package com.example.test;

import com.example.servlet.StudentServlet;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: 刘欢
 * @Date: 2019/10/28 18:41
 */
public class Day06Test {

    /**
     * 测试spring的三层架构下的面向切面编程(AOP)
     */
    @Test
    public void spring01(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        StudentServlet studentServlet = applicationContext.getBean("studentServlet", StudentServlet.class);
        studentServlet.doIt();
    }
}
