package com.example.entity;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Author: 刘欢
 * @Date: 2019/10/28 18:27
 */
@Component("dayOfDay")
@Scope("prototype")
public class DayOfDay {
//    DayOfDay(){
//        System.out.println("DayOfDay 被初始化");
//    }

    /**
     * 环绕通知
     * @param joinPoint
     */
    public void login(ProceedingJoinPoint joinPoint) throws Throwable {
        boolean boo = false;
        if (boo){
            System.out.println("登录成功");
            joinPoint.proceed();
        }else{
            System.out.println("登录失败");
        }
    }

    /**
     * 前置通知
     */
    public void wishHands(){
        System.out.println("先洗手");
    }

    /**
     * 后置通知
     */
    public void wishBowls(){
        System.out.println("洗碗");
    }

    /**
     * 接收返回值的通知
     * @param str
     */
    public void getReturn(String str){
        System.out.println("我得到了核心方法的返回值 : "+str);
    }

    /**
     * 报错后被调用的通知
     * @param ex
     */
    public void getException(Exception ex){
        System.out.println("核心方法报错\n");
        ex.printStackTrace();
    }

}
