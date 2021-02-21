package com.example.dao;

import java.util.List;
import java.util.Map;

/**
 * @Author: 刘欢
 * @Date: 2019/10/29 9:52
 */
public interface EmpMapper {

    /**
     * 根据不同参数得到不同的结果，传入的参数个数不固定
     * @param map
     * @return
     */
    List<Map<String,Object>> queryEmpByRelative(Map<String,Object> map);
}
