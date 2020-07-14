package com.web.recruit.entity;

public class Resume {  //简历
    private Integer resumeId;

    private Integer resumeUserId;

    private String resumeContent;

    private String resumeWorkDesire;

    private String resumeWorkExperience;

    public Resume() {
    }

    public Integer getResumeId() {
        return resumeId;
    }

    public void setResumeId(Integer resumeId) {
        this.resumeId = resumeId;
    }

    public Integer getResumeUserId() {
        return resumeUserId;
    }

    public void setResumeUserId(Integer resumeUserId) {
        this.resumeUserId = resumeUserId;
    }

    public String getResumeContent() {
        return resumeContent;
    }

    public void setResumeContent(String resumeContent) {
        this.resumeContent = resumeContent;
    }

    public String getResumeWorkDesire() {
        return resumeWorkDesire;
    }

    public void setResumeWorkDesire(String resumeWorkDesire) {
        this.resumeWorkDesire = resumeWorkDesire;
    }

    public String getResumeWorkExperience() {
        return resumeWorkExperience;
    }

    public void setResumeWorkExperience(String resumeWorkExperience) {
        this.resumeWorkExperience = resumeWorkExperience;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "resumeId=" + resumeId +
                ", resumeUserId=" + resumeUserId +
                ", resumeContent='" + resumeContent + '\'' +
                ", resumeWorkDesire='" + resumeWorkDesire + '\'' +
                ", resumeWorkExperience='" + resumeWorkExperience + '\'' +
                '}';
    }
}