package com.example.service.impl;

import com.example.entity.Project;
import com.example.entity.WorkOrder;
import com.example.mapper.ProjectMapper;
import com.example.mapper.WorkOrderMapper;
import com.example.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: 刘欢
 * @Date: 2019/11/5 14:02
 */
@Service
public class DataServiceImpl implements DataService {
    @Autowired
    ProjectMapper projectMapper;

    @Autowired
    WorkOrderMapper workOrderMapper;

    @Override
    public List<Project> queryAllByProject() {
        return projectMapper.queryAll();
    }

    @Override
    public boolean insertWorkOrder(Map<String,Object> map) {
        return workOrderMapper.insert(map)>0?true:false;
    }

    @Override
    public List<WorkOrder> queryAllByWorkOrder() {
        return workOrderMapper.queryAll();
    }
}
