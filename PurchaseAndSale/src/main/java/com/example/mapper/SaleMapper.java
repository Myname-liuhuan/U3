package com.example.mapper;

import java.util.List;
import java.util.Map;

/**
 * @Author: 刘欢
 * @Date: 2019/11/6 16:08
 */
public interface SaleMapper {

    /**
     * 向sale表中插入一行数据
     * @param map
     * @return
     */
    Integer insert(Map<String,Object> map);

    /**
     * 查询sale表中所有数据
     * @param orderBy
     * @return
     */
    List<Map<String,Object>> queryAll(Integer orderBy);
}
