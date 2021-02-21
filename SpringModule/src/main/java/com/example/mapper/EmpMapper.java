package com.example.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author: 刘欢
 * @Date: 2019/10/30 16:55
 */
public interface EmpMapper {

    /**
     * 根据不同参数得到不同的结果，传入的参数个数不固定
     * @param map
     * @return
     */
    List<Map<String,Object>> queryEmpByRelative(Map<String,Object> map);

    /**
     * 传多个参数查询结果
     * @param esex
     * @param epay
     * @return
     */
    List<Map<String,Object>> queryEmpByParams(@Param("esex") String esex,@Param("epay") Double epay);
}
