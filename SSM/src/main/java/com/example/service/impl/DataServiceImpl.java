package com.example.service.impl;

import com.example.entity.Dept;
import com.example.entity.Emp;
import com.example.mapper.DeptMapper;
import com.example.mapper.EmpMapper;
import com.example.service.DataService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: 刘欢
 * @Date: 2019/11/3 22:09
 */
@Service
public class DataServiceImpl implements DataService {

    @Autowired
    EmpMapper empMapper;
    @Autowired
    DeptMapper deptMapper;

    @Override
    public PageInfo queryEmpOfPage(Map<String, Object> map, Integer pageNum, Integer pageSize) {
        /**
         * 先为分页设置参数
         * pageNum 当前第几页 从前台页面传入
         * pageSize 每页最多显示多少条数据 一般为设计者自己定义
         */
        PageHelper.startPage(pageNum,pageSize);

        List<Emp> empList = empMapper.queryAll(map);

        PageInfo pageInfo = new PageInfo(empList);

        return pageInfo;
    }

    @Override
    public List<Dept> queryAllByDept() {
        return deptMapper.queryAll();
    }

    @Override
    public boolean insertEmp(Emp emp) {
        return empMapper.insert(emp)>0?true:false;
    }

    @Override
    public Emp oneLineOfEmp(String eid) {
        return empMapper.oneLine(eid);
    }

    @Override
    public boolean updateEmp(Emp emp) {
        return empMapper.update(emp)>0?true:false;
    }

    @Override
    public boolean deleteEmp(String eid) {
        return empMapper.delete(eid)>0?true:false;
    }
}
