package com.example.entity;

import java.util.Date;

/**
 * @author liuhuan
 */
public class WorkOrder {
    private Integer id;

    private Integer projectId;

    private String executor;

    private String description;

    private Integer orderLevel;

    private Date createDate;

    public WorkOrder() {
    }

    public WorkOrder(Integer id, Integer projectId, String executor, String description, Integer orderLevel, Date createDate) {
        this.id = id;
        this.projectId = projectId;
        this.executor = executor;
        this.description = description;
        this.orderLevel = orderLevel;
        this.createDate = createDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getOrderLevel() {
        return orderLevel;
    }

    public void setOrderLevel(Integer orderLevel) {
        this.orderLevel = orderLevel;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}