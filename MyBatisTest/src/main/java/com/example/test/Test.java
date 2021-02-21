package com.example.test;

import com.example.dao.EmpMapper;
import com.example.dao.HusbandMapper;
import com.example.entity.Husband;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 刘欢
 * @Date: 2019/10/29 9:57
 */
public class Test {
    SqlSession sqlSession = null;

    @Before
    public void init() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
    }

    /**
     * 测试查询Husband表所有数据
     */
    @org.junit.Test
    public void test1(){
        List<Husband> husbands = sqlSession.getMapper(HusbandMapper.class).queryAll();
        for (Husband husband : husbands) {
            System.out.println(husband);
        }
    }

    /**
     * 向表Husband中插入一行数
     */
    @org.junit.Test
    public void test2(){
        Husband husband = new Husband(null,24,"男","H");
        sqlSession.getMapper(HusbandMapper.class).insertHusband(husband);
    }

    /**
     * 修改表husband一行数据
     */
    @org.junit.Test
    public void test3(){
        Husband husband = new Husband(3,23,"男","M");
        sqlSession.getMapper(HusbandMapper.class).updateHusband(husband);
    }

    /**
     * 删除Husband表一行
     */
    @org.junit.Test
    public void test4(){
        Integer husId = 0;
        sqlSession.getMapper(HusbandMapper.class).deleteHusband(husId);
    }

    /**
     * 动态查询emp表
     */
    @org.junit.Test
    public void test5(){
        Map<String,Object> map = new HashMap<>();
        map.put("did",1);
        sqlSession.getMapper(EmpMapper.class).queryEmpByRelative(map);
    }

    /**
     * 分页查询
     */
    @org.junit.Test
    public void test6(){
        Integer pageNow = 1;
        Integer pageSize = 5;
        PageHelper.startPage(pageNow,pageSize);
        sqlSession.getMapper(EmpMapper.class).queryEmpByRelative(null);
    }


    @After
    public void destroy(){
        if (sqlSession != null){
            sqlSession.commit();
            sqlSession.close();
        }
    }
}
