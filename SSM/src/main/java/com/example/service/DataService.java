package com.example.service;

import com.example.entity.Dept;
import com.example.entity.Emp;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * @Author: 刘欢
 * @Date: 2019/11/3 15:24
 */
public interface DataService {

    /**
     * 对emp表分页查询
     * @param map 查询的限制条件
     * @param pageNum 第几页
     * @param pageSize 每页几条数据
     * @return 封装了一系列数据的实体类(第三方提供)
     */
    PageInfo queryEmpOfPage(Map<String,Object> map,Integer pageNum,Integer pageSize);

    /**
     * 查询dept表所有数据
     * @return
     */
    List<Dept> queryAllByDept();

    /**
     * 向Emp表插入一行数据
     * @param emp
     * @return
     */
    boolean insertEmp(Emp emp);

    /**
     * 查询emp表一行数据，根据eid
     * @param eid
     * @return
     */
    Emp oneLineOfEmp(String eid);

    /**
     * 更新emp表一行数据
     * @param emp
     * @return
     */
    boolean updateEmp(Emp emp);

    /**
     * 删除emp表一行数据
     * @param eid
     * @return
     */
    boolean deleteEmp(String eid);
}
