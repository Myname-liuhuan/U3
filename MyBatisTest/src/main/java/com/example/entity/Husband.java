package com.example.entity;

/**
 * @Author: 刘欢
 * @Date: 2019/10/27 9:34
 */
public class Husband {
    private Integer husId;
    private Integer age;
    private String gender;
    private String HusbandName;

    public Husband() {
    }

    public Husband(Integer husId, Integer age, String gender, String husbandName) {
        this.husId = husId;
        this.age = age;
        this.gender = gender;
        HusbandName = husbandName;
    }

    public Integer getHusId() {
        return husId;
    }

    public void setHusId(Integer husId) {
        this.husId = husId;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHusbandName() {
        return HusbandName;
    }

    public void setHusbandName(String husbandName) {
        HusbandName = husbandName;
    }

    @Override
    public String toString() {
        return "Husband{" +
                "husId=" + husId +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", HusbandName='" + HusbandName + '\'' +
                '}';
    }
}
