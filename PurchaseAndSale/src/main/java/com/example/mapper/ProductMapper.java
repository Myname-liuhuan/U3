package com.example.mapper;

import com.example.entity.Product;

import java.util.List;
import java.util.Map;

/**
 * @Author: 刘欢
 * @Date: 2019/11/6 15:51
 */
public interface ProductMapper {

    /**
     * 查询product表的所有数据
     * @return
     */
    List<Product> queryAll();

    /**
     * 根据条件修改产品数量
     * @param map
     * @return
     */
    Integer update(Map<String,Object> map);
}
