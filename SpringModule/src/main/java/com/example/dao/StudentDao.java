package com.example.dao;

import com.example.entity.Student;

import java.util.List;

/**
 * @Author: 刘欢
 * @Date: 2019/10/28 18:32
 */
public interface StudentDao {

    /**
     * 吃早饭
     * @return
     */
    void eatBreakFast();

    /**
     * 吃午饭
     */
    void eatLunch();

    /**
     * 吃早饭
     * @return
     */
    String  eatDinner();

}
