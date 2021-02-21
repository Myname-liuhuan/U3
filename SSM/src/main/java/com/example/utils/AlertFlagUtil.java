package com.example.utils;

import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: 刘欢
 * @Date: 2019/11/5 8:47
 */
public class AlertFlagUtil {
    public static ModelAndView setModelAndView(ModelAndView modelAndView, String updateType, boolean flag){
        if (flag){
            modelAndView.addObject("update",updateType);
        }
        return modelAndView;
    }
}
