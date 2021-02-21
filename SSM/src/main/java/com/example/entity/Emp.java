package com.example.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author liuhuan
 */
public class Emp {
    private Integer eid;

    private String eName;

    private String eSex;
    /**
     * 因为springMVC的默认转换器没法将前端传来的String解析为java.lang.Date类型
     * 所以需要添加注解 转换类型
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date eStartTime;

    private Double ePay;

    private Integer did;

    private Dept dept;

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String geteSex() {
        return eSex;
    }

    public void seteSex(String eSex) {
        this.eSex = eSex;
    }

    public Date geteStartTime() {
        return eStartTime;
    }

    public void seteStartTime(Date eStartTime) {
        this.eStartTime = eStartTime;
    }

    public Double getePay() {
        return ePay;
    }

    public void setePay(Double ePay) {
        this.ePay = ePay;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "eid=" + eid +
                ", eName='" + eName + '\'' +
                ", eSex='" + eSex + '\'' +
                ", eStartTime=" + eStartTime +
                ", ePay=" + ePay +
                ", did=" + did +
                ", dept=" + dept +
                '}';
    }
}