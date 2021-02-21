package com.example.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Author: 刘欢
 * @Date: 2019/10/28 18:27
 *
 * @Component : 标记该类为spring管理(生命周期,对象间的依赖)
 * @Repository  : 标记为dao层类
 * @Service : 标记为Service层类
 * @Controller  : 标记为Controller层类(Servlet)
 */
@Component("student")
@Scope("prototype")
public class Student {
    /**
     * @Value : 普通属性的注入(基本数据类型及其包装类 + String)
     * @Autowired : 用于对象属性的注入(也叫域属性，关联属性)--Spring提供
     *           可以作用在属性上和set方法上，如果在属性上不用写set方法，
     * @Resource : 同样用于对象属性的注入 -- java jdk提供
     */
    @Autowired
    DayOfDay dayOfDay;

    public Student(){
        System.out.println("Student 被初始化");
    }

}