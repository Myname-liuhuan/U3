package com.example.mapper;

import com.example.entity.Dept;

import java.util.List;

/**
 * @Author: 刘欢
 * @Date: 2019/11/4 9:44
 */
public interface DeptMapper {

    /**
     * 查询dept表所有数据
     * @return
     */
    List<Dept> queryAll();
}
