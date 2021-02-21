package com.example.service;

import com.example.entity.Product;
import com.example.entity.Users;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * @Author: 刘欢
 * @Date: 2019/11/6 12:38
 */
public interface DataService {

    /**
     * 将表单验证的数据进行数据库中的判断
     * 并经过判断 要么返回一个null的users对象，
     * 要么返回一个携带完整数据的users
     * @param map
     * @return
     */
    Users checkForm(Map<String,Object> map);


    /**
     * 查询product表的所有数据
     * @return
     */
    List<Product> queryAllOfProduct();


    /**
     * 向sale表中插入一行数据,同时在产品表中减去对应产品的产品数量
     * 使用事务 要么全部成功 要么全部失败。
     * @param map
     * @return
     */
    boolean insertTransaction(Map<String,Object> map);

    /**
     * 查询sale表中所有数据
     * 并分页
     * @param pageNum 第几页
     * @param orderBy 排序的字段
     * @return
     */
    PageInfo queryAllBySale(Integer pageNum,Integer orderBy);
}
