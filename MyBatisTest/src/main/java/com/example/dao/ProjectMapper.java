package com.example.dao;

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
}