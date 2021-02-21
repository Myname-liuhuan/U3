package com.example.mapper;

import com.example.entity.Users;

import java.util.List;
import java.util.Map;

/**
 * @Author: 刘欢
 * @Date: 2019/11/6 11:49
 */
public interface UsersMapper {

    /**
     * 将表单验证的数据进行数据库中的判断 看其是否存在
     * @param map
     * @return
     */
    List<Users> checkForm(Map<String,Object> map);
}
