package com.example.dao.impl;

import com.example.dao.StudentDao;
import com.example.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 刘欢
 * @Date: 2019/10/28 18:35
 */
@Repository
public class StudentDaoImpl implements StudentDao {

    @Override
    public void eatBreakFast(){
        System.out.println("我次了早饭");
    }

    @Override
    public void eatLunch() {
        System.out.println("我吃了午饭");
    }

    @Override
    public String  eatDinner() {
        System.out.println("我吃了晚饭");
        return "今天结束";
    }


}
