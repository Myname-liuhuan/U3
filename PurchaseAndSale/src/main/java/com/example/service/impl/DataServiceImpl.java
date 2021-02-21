package com.example.service.impl;

import com.example.entity.Product;
import com.example.entity.Users;
import com.example.mapper.ProductMapper;
import com.example.mapper.SaleMapper;
import com.example.mapper.UsersMapper;
import com.example.service.DataService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Author: 刘欢
 * @Date: 2019/11/6 12:55
 */
@Service
public class DataServiceImpl implements DataService {

    @Autowired
    UsersMapper usersMapper;
    @Autowired
    ProductMapper productMapper;
    @Autowired
    SaleMapper saleMapper;

    @Override
    public Users checkForm(Map<String, Object> map) {
        Users users=null;
        List<Users> usersList = usersMapper.checkForm(map);

        if (usersList!=null && usersList.size()>0){
            users = usersList.get(0);
        }
        return users;
    }

    @Override
    public List<Product> queryAllOfProduct() {
        return productMapper.queryAll();
    }


    /**
     * 只有两个数据库操作全部成功才返回true 否则就返回false
     * @param map
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW,
            rollbackFor = Exception.class)
    @Override
    public boolean insertTransaction(Map<String, Object> map) {
        Integer i = saleMapper.insert(map);
        Integer update = productMapper.update(map);
        //同时成功才会继续执行
        if (i > 0 && update > 0){
            return true;
        }
        return false;
    }

    @Override
    public PageInfo queryAllBySale(Integer pageNum,Integer orderBy) {
        PageHelper.startPage(pageNum,5);
        PageInfo pageInfo = new PageInfo(saleMapper.queryAll(orderBy));

        return pageInfo;
    }
}
