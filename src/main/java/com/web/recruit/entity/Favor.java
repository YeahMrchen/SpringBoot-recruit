package com.web.recruit.entity;

public class Favor {   //职位申请
    private Integer favorId;

    private Integer favorPositionId;

    private Integer favorResumeId;

    //申请状态：-1为拒绝，0为未批，1为通过
    private Integer favorState;

    public Favor() {
    }

    public Integer getFavorId() {
        return favorId;
    }

    public void setFavorId(Integer favorId) {
        this.favorId = favorId;
    }

    public Integer getFavorPositionId() {
        return favorPositionId;
    }

    public void setFavorPositionId(Integer favorPositionId) {
        this.favorPositionId = favorPositionId;
    }

    public Integer getFavorResumeId() {
        return favorResumeId;
    }

    public void setFavorResumeId(Integer favorResumeId) {
        this.favorResumeId = favorResumeId;
    }

    public Integer getFavorState() {
        return favorState;
    }

    public void setFavorState(Integer favorState) {
        this.favorState = favorState;
    }

    @Override
    public String toString() {
        return "Favor{" +
                "favorId=" + favorId +
                ", favorPositionId=" + favorPositionId +
                ", favorResumeId=" + favorResumeId +
                ", favorState=" + favorState +
                '}';
    }
}