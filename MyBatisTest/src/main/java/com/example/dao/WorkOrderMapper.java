package com.example.dao;

import com.example.entity.WorkOrder;

import java.util.List;

/**
 * @author liuhuan
 */
public interface WorkOrderMapper {

    /**
     * 向workOrder 表中插入一组数据
     * @param workOrderList
     * @return
     */
    Integer insertWorkOrder(List<WorkOrder> workOrderList);
}