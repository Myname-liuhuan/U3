package com.example.controller;

import com.example.entity.Emp;
import com.example.service.impl.DataServiceImpl;
import com.example.utils.AlertFlagUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Author: 刘欢
 * @Date: 2019/11/3 19:49
 * 在Controller中的方法，都分为三个部分
 * 接收前台数据
 * 域存储数据
 * 返回页面(servlet)地址
 */
@Controller
public class MainController {
    @Autowired
    DataServiceImpl dataService;
    /**
     * 分页查询主界面
     * @RequestParam 表示给参数配置默认值
     * @return
     */
    @RequestMapping("/main")
    public ModelAndView main(@RequestParam Map<String,Object> map, @RequestParam(defaultValue = "1") Integer pageNum, ModelAndView modelAndView, HttpSession session){
        PageInfo pageInfo = dataService.queryEmpOfPage(map, pageNum, 5);
        modelAndView.addObject("back",map);
        modelAndView.addObject("pageInfo",pageInfo);
        session.setAttribute("deptList",dataService.queryAllByDept());
        modelAndView.setViewName("/pages/main.jsp");
        return modelAndView;
    }

    @RequestMapping("/insert")
    public ModelAndView insert(Emp emp,ModelAndView modelAndView){
        boolean b = dataService.insertEmp(emp);
        modelAndView.setViewName("forward:/main.lh");
        return AlertFlagUtil.setModelAndView(modelAndView,"insert",b);

    }

    @RequestMapping("/oneLine")
    public ModelAndView oneLine(String eid, ModelAndView modelAndView){
        Emp emp = dataService.oneLineOfEmp(eid);
        modelAndView.addObject("emp",emp);
        modelAndView.setViewName("/pages/update.jsp");
        return modelAndView;
    }

    @RequestMapping("/update")
    public ModelAndView update(Emp emp,ModelAndView modelAndView){
        boolean b = dataService.updateEmp(emp);
        modelAndView.setViewName("forward:/main.lh");
        return AlertFlagUtil.setModelAndView(modelAndView,"update",b);
    }

    @RequestMapping("/delete")
    public ModelAndView delete(String eid,ModelAndView modelAndView){
        boolean b = dataService.deleteEmp(eid);
        modelAndView.setViewName("forward:/main.lh");
        return AlertFlagUtil.setModelAndView(modelAndView,"delete",b);
    }
}
