package com.example.service.impl;

import com.example.mapper.EmpMapper;
import com.example.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: 刘欢
 * @Date: 2019/10/30 17:20
 */
@Service("empService")
public class EmpServiceImpl implements EmpService {
    @Autowired
    EmpMapper empMapper;

    @Override
    public List<Map<String, Object>> queryEmpByRelative(Map<String, Object> map) {
        return empMapper.queryEmpByRelative(map);
    }

    @Override
    public List<Map<String, Object>> queryEmpByParams(String esex, Double eplay) {
        return empMapper.queryEmpByParams(esex,eplay);
    }
}
