package com.example.mapper;

import com.example.entity.Emp;

import java.util.List;
import java.util.Map;

/**
 * @Author: 刘欢
 * @Date: 2019/11/3 15:23
 */
public interface EmpMapper {

    /**
     * 查询emp表所有数据
     * @param map 限制参数
     * @return
     */
    List<Emp> queryAll(Map<String,Object> map);

    /**
     * 向emp表中插入一行数据
     * @param emp
     * @return
     */
    Integer insert(Emp emp);

    /**
     * 根据eid查询出emp表的一行数据
     * @param eid
     * @return
     */
    Emp oneLine(String eid);

    /**
     * 根据eid更新一行数据
     * @param emp
     * @return
     */
    Integer update(Emp emp);

    /**
     * 根据eid删除一行数据
     * @param eid
     * @return
     */
    Integer delete(String eid);
}
