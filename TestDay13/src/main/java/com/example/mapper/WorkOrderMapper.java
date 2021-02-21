package com.example.mapper;

import com.example.entity.WorkOrder;

import java.util.List;
import java.util.Map;

/**
 * @author liuhuan
 */
public interface WorkOrderMapper {

    /**
     * 向workOrder 表中插入多行数据
     * @param workOrderList
     * @return
     */
    Integer insertWorkOrder(List<WorkOrder> workOrderList);

    /**
     * 向表中插入一行数据
     * @param map
     * @return
     */
    Integer insert(Map<String,Object> map);

    /**
     * 查询workOrder表所有数据
     * @return
     */
    List<WorkOrder> queryAll();

}