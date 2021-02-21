package com.example.controller;

import com.example.entity.Project;
import com.example.entity.WorkOrder;
import com.example.service.impl.DataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author: 刘欢
 * @Date: 2019/11/5 14:04
 */
@Controller
@RequestMapping
public class MainController {

    @Autowired
    DataServiceImpl dataService;

    @RequestMapping("/first")
    public ModelAndView first(ModelAndView modelAndView){
        List<Project> projectList = dataService.queryAllByProject();
        modelAndView.addObject("projectList",projectList);
        modelAndView.setViewName("/pages/first.jsp");
        return modelAndView;
    }

    @RequestMapping("addIn")
    public String addIn(String projectId, Model model){
        model.addAttribute("projectId",projectId);
        return "/pages/add.jsp";
    }

    @RequestMapping("addOut")
    public ModelAndView addOut(@RequestParam Map<String,Object> map, ModelAndView modelAndView){
        boolean b = dataService.insertWorkOrder(map);
        if (b){
            modelAndView.addObject("insert",true);
        }else{
            modelAndView.addObject("insert",false);
        }
        List<WorkOrder> workOrderList = dataService.queryAllByWorkOrder();
        modelAndView.addObject("workOrderList",workOrderList);
        modelAndView.setViewName("/pages/all.jsp");
        return modelAndView;
    }
}
