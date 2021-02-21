package com.example.controller;

import com.example.entity.Users;
import com.example.service.impl.DataServiceImpl;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Author: 刘欢
 * @Date: 2019/11/6 10:59
 */
@Controller
@RequestMapping
public class MainController {

    @Autowired
    DataServiceImpl dataService;

    /**
     * 使用ajax验证就需要使用ResponseBody注解，因为返回的不再是页面 而是数据了
     * @param map
     * @return
     */
    @RequestMapping("login")
    @ResponseBody
    public Boolean login(@RequestParam Map<String,Object> map, HttpSession session){
        Users users = dataService.checkForm(map);
        if (users!=null){
            session.setAttribute("productList",dataService.queryAllOfProduct());
            session.setAttribute("users",users);
            return true;
        }
        return false;
    }

    @RequestMapping("add")
    public ModelAndView add(@RequestParam Map<String,Object> map,ModelAndView modelAndView,HttpSession session){
        boolean b = dataService.insertTransaction(map);
        if (b){
            modelAndView.addObject("update","insert");
        }
        //把session中保存的值更新一下
        session.removeAttribute("productList");
        session.setAttribute("productList",dataService.queryAllOfProduct());

        modelAndView.setViewName("/pages/addSale.jsp");
        return modelAndView;
    }

    /**
     * 当前台传来的值有可能不存在的时候需要在字段前面添加
     * @RequestRaram(required = false)注解 其中required = false表示允许字段不存在，默认是true的，即不允许该字段在前台页面不存在
     * @param pageNum
     * @param orderBy
     * @param modelAndView
     * @return
     */
    @RequestMapping("query")
    public ModelAndView query(@RequestParam(defaultValue = "1") Integer pageNum,@RequestParam(required = false) Integer orderBy, ModelAndView modelAndView){
        System.out.println(orderBy);
        PageInfo pageInfo = dataService.queryAllBySale(pageNum,orderBy);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("/pages/selectSale.jsp");
        return modelAndView;
    }


}
