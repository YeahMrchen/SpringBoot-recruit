package com.web.recruit.entity;

import java.util.Date;

public class HR {
    private Integer hrId;

    private String hrAccount;

    private String hrPassword;

    private Integer hrCompanyId;

    private String hrName;

    private Integer hrGender;

    private String hrMobile;

    private Date hrEntryDate;

    public HR() {
    }

    public Integer getHrId() {
        return hrId;
    }

    public void setHrId(Integer hrId) {
        this.hrId = hrId;
    }

    public String getHrAccount() {
        return hrAccount;
    }

    public void setHrAccount(String hrAccount) {
        this.hrAccount = hrAccount;
    }

    public String getHrPassword() {
        return hrPassword;
    }

    public void setHrPassword(String hrPassword) {
        this.hrPassword = hrPassword;
    }

    public Integer getHrCompanyId() {
        return hrCompanyId;
    }

    public void setHrCompanyId(Integer hrCompanyId) {
        this.hrCompanyId = hrCompanyId;
    }

    public String getHrName() {
        return hrName;
    }

    public void setHrName(String hrName) {
        this.hrName = hrName;
    }

    public Integer getHrGender() {
        return hrGender;
    }

    public void setHrGender(Integer hrGender) {
        this.hrGender = hrGender;
    }

    public String getHrMobile() {
        return hrMobile;
    }

    public void setHrMobile(String hrMobile) {
        this.hrMobile = hrMobile;
    }

    public Date getHrEntryDate() {
        return hrEntryDate;
    }

    public void setHrEntryDate(Date hrEntryDate) {
        this.hrEntryDate = hrEntryDate;
    }

    @Override
    public String toString() {
        return "HR{" +
                "hrId=" + hrId +
                ", hrAccount='" + hrAccount + '\'' +
                ", hrPassword='" + hrPassword + '\'' +
                ", hrCompanyId=" + hrCompanyId +
                ", hrName='" + hrName + '\'' +
                ", hrGender=" + hrGender +
                ", hrMobile='" + hrMobile + '\'' +
                ", hrEntryDate=" + hrEntryDate +
                '}';
    }
}