package com.example.service;

import com.example.entity.Project;
import com.example.entity.WorkOrder;

import java.util.List;
import java.util.Map;

/**
 * @Author: 刘欢
 * @Date: 2019/11/5 14:01
 */
public interface DataService {

    /**
     * 查询project表所有数据
     * @return
     */
    List<Project> queryAllByProject();

    /**
     * 向workOrder表中插入一行数据
     * @param map
     * @return
     */
    boolean insertWorkOrder(Map<String,Object> map);

    /**
     * 查询workOrder表的所有数据
     * @return
     */
    List<WorkOrder> queryAllByWorkOrder();

}
