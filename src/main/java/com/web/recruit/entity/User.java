package com.web.recruit.entity;

import java.util.Date;

public class User {  //用户
    private Integer userId;

    private String userAccount;

    private String userPassword;

    private String userName;

    private Date userBirth;

    private Integer userGender;

    private String userGraduation;

    private String userEduDegree;

    private Integer userPositionId;

    public User() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(Date userBirth) {
        this.userBirth = userBirth;
    }

    public Integer getUserGender() {
        return userGender;
    }

    public void setUserGender(Integer userGender) {
        this.userGender = userGender;
    }

    public String getUserGraduation() {
        return userGraduation;
    }

    public void setUserGraduation(String userGraduation) {
        this.userGraduation = userGraduation;
    }

    public String getUserEduDegree() {
        return userEduDegree;
    }

    public void setUserEduDegree(String userEduDegree) {
        this.userEduDegree = userEduDegree;
    }

    public Integer getUserPositionId() {
        return userPositionId;
    }

    public void setUserPositionId(Integer userPositionId) {
        this.userPositionId = userPositionId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userAccount='" + userAccount + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userName='" + userName + '\'' +
                ", userBirth=" + userBirth +
                ", userGender=" + userGender +
                ", userGraduation='" + userGraduation + '\'' +
                ", userEduDegree='" + userEduDegree + '\'' +
                ", userPositionId=" + userPositionId +
                '}';
    }
}