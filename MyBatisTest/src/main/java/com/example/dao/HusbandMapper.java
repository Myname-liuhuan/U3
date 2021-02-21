package com.example.dao;

import com.example.entity.Husband;

import java.util.List;

/**
 * @Author: 刘欢
 * @Date: 2019/10/29 9:54
 */
public interface HusbandMapper {

    /**
     * 查询husband表所有数据
     * @return
     */
    List<Husband> queryAll();


    /**
     * 向husband表中插入一行数据
     * @param husband
     * @return
     */
    Integer insertHusband(Husband husband);

    /**
     * 更新Husband表的一行数据
     * @param husband
     * @return
     */
    Integer updateHusband(Husband husband);

    /**
     * 删除表Husband中一行数据
     * @param husId
     * @return
     */
    Integer deleteHusband(Integer husId);
}
