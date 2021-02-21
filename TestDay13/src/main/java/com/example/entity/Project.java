package com.example.entity;


/**
 * @author liuhuan
 */
public class Project {
    private Long id;

    private String projectName;

    public Project() {
    }

    public Project(Long id, String projectName) {
        this.id = id;
        this.projectName = projectName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                '}';
    }
}