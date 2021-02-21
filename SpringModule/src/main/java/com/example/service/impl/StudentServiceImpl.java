package com.example.service.impl;

import com.example.dao.StudentDao;
import com.example.dao.impl.StudentDaoImpl;
import com.example.entity.Student;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 刘欢
 * @Date: 2019/10/28 18:50
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentDao studentDao;

    @Override
    public void eatBreakFast() {
        studentDao.eatBreakFast();
    }

    @Override
    public void eatLunch() {
        studentDao.eatLunch();
    }

    @Override
    public void eatDinner() {
        studentDao.eatDinner();
    }
}
