package com.example.service.impl;

import com.example.dao.ProjectMapper;
import com.example.dao.WorkOrderMapper;
import com.example.entity.Project;
import com.example.entity.WorkOrder;
import com.example.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 刘欢
 * @Date: 2019/11/1 9:51
 */
//@Service("projectService")
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    ProjectMapper projectMapper;
    @Autowired
    WorkOrderMapper workOrderMapper;

    @Override
    public Integer insertProject(Project project) {
        return projectMapper.insertProject(project);
    }

    @Override
    public Integer insertWorkOrder(List<WorkOrder> workOrderList) {
        return workOrderMapper.insertWorkOrder(workOrderList);
    }


}
