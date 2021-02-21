package com.example.servlet;

import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @Author: 刘欢
 * @Date: 2019/10/28 18:52
 */
@Controller("studentServlet")
public class StudentServlet {
    @Autowired
    StudentService studentService;

    public void doIt(){
        studentService.eatBreakFast();
        studentService.eatLunch();
        studentService.eatDinner();
    }
}
