package com.oj.gkuoj.response;

import java.io.Serializable;

public class UserProblemRecordVO implements Serializable {

    private Integer acCount;

    private Integer tleCount;

    private Integer peCount;

    private Integer meCount;

    private Integer ceCount;

    private Integer reCount;

    private Integer waCount;


    public Integer getAcCount() {
        return acCount;
    }

    public void setAcCount(Integer acCount) {
        this.acCount = acCount;
    }

    public Integer getTleCount() {
        return tleCount;
    }

    public void setTleCount(Integer tleCount) {
        this.tleCount = tleCount;
    }

    public Integer getPeCount() {
        return peCount;
    }

    public void setPeCount(Integer peCount) {
        this.peCount = peCount;
    }

    public Integer getMeCount() {
        return meCount;
    }

    public void setMeCount(Integer meCount) {
        this.meCount = meCount;
    }

    public Integer getCeCount() {
        return ceCount;
    }

    public void setCeCount(Integer ceCount) {
        this.ceCount = ceCount;
    }

    public Integer getReCount() {
        return reCount;
    }

    public void setReCount(Integer reCount) {
        this.reCount = reCount;
    }

    public Integer getWaCount() {
        return waCount;
    }

    public void setWaCount(Integer waCount) {
        this.waCount = waCount;
    }

    @Override
    public String toString() {
        return "UserProblemRecordVO{" +
                "acCount=" + acCount +
                ", tleCount=" + tleCount +
                ", peCount=" + peCount +
                ", meCount=" + meCount +
                ", ceCount=" + ceCount +
                ", reCount=" + reCount +
                ", waCount=" + waCount +
                '}';
    }
}
