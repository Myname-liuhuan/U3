package com.example.entity;

/**
 * @author liuhuan
 */
public class Dept {
    private Integer did;

    private String dName;

    private String dTel;

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getdTel() {
        return dTel;
    }

    public void setdTel(String dTel) {
        this.dTel = dTel;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "did=" + did +
                ", dName='" + dName + '\'' +
                ", dTel='" + dTel + '\'' +
                '}';
    }
}