package com.example.service;

import com.example.entity.Project;
import com.example.entity.WorkOrder;

import java.util.List;

/**
 * @Author: 刘欢
 * @Date: 2019/11/1 9:50
 */
public interface ProjectService {

    /**
     * 向project表中添加一行数据
     * @param project
     * @return
     */
    Integer insertProject(Project project);

    /**
     * 向workOrder表中插入多行数据
     * @param workOrderList
     * @return
     */
    Integer insertWorkOrder(List<WorkOrder> workOrderList);
}
