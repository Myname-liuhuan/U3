package com.example.mapper;

import com.example.entity.Project;

import java.util.List;

/**
 * @author liuhuan
 */
public interface ProjectMapper {

    /**
     * 向project表中插入一行数据
     * @param record
     * @return
     */
    int insertProject(Project record);

    /**
     * 查询project 表中所有数据
     * @return
     */
    List<Project> queryAll();
}