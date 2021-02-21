package com.example.test;

import com.example.entity.Project;
import com.example.entity.WorkOrder;
import com.example.service.ProjectService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: 刘欢
 * @Date: 2019/11/1 9:52
 */
public class SpringMybatisTest {
    ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
    ProjectService projectService = context.getBean("projectService", ProjectService.class);


    /**
     * 测试向project中插一行
     */
    @Test
    public void test1(){
        Project project = new Project(1L,"day05");
        Integer i = projectService.insertProject(project);
        System.out.println(i);
    }

    /**
     * 测试向workOrder中插入一个集合bean
     */
    @Test
    public void test2(){
        WorkOrder w1 = new WorkOrder(1,1,"Henry","desc",2,new Date());
        WorkOrder w2 = new WorkOrder(2,1,"Lucy","rip",1,new Date());
        WorkOrder w3 = new WorkOrder(3,1,"Adele","tion",4,new Date());
        List<WorkOrder> workOrderList = new ArrayList<>();
        workOrderList.add(w1);
        workOrderList.add(w2);
        workOrderList.add(w3);

        Integer i = projectService.insertWorkOrder(workOrderList);
        System.out.println(i);
    }

}
