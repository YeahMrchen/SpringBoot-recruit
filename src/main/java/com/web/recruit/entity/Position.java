package com.web.recruit.entity;

public class Position {   //工作岗位
    private Integer positionId;

    private Integer positionCategoryId;

    private Integer positionCompanyId;

    private String positionName;

    private Integer positionQuantity;

    private String positionDescription;

    private Integer positionSalaryDown;

    private Integer positionSalaryUp;

    private String positionCity;

    private String positionAddress;

    public Position() {
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public Integer getPositionCategoryId() {
        return positionCategoryId;
    }

    public void setPositionCategoryId(Integer positionCategoryId) {
        this.positionCategoryId = positionCategoryId;
    }

    public Integer getPositionCompanyId() {
        return positionCompanyId;
    }

    public void setPositionCompanyId(Integer positionCompanyId) {
        this.positionCompanyId = positionCompanyId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Integer getPositionQuantity() {
        return positionQuantity;
    }

    public void setPositionQuantity(Integer positionQuantity) {
        this.positionQuantity = positionQuantity;
    }

    public String getPositionDescription() {
        return positionDescription;
    }

    public void setPositionDescription(String positionDescription) {
        this.positionDescription = positionDescription;
    }

    public Integer getPositionSalaryDown() {
        return positionSalaryDown;
    }

    public void setPositionSalaryDown(Integer positionSalaryDown) {
        this.positionSalaryDown = positionSalaryDown;
    }

    public Integer getPositionSalaryUp() {
        return positionSalaryUp;
    }

    public void setPositionSalaryUp(Integer positionSalaryUp) {
        this.positionSalaryUp = positionSalaryUp;
    }

    public String getPositionCity() {
        return positionCity;
    }

    public void setPositionCity(String positionCity) {
        this.positionCity = positionCity;
    }

    public String getPositionAddress() {
        return positionAddress;
    }

    public void setPositionAddress(String positionAddress) {
        this.positionAddress = positionAddress;
    }

    @Override
    public String toString() {
        return "Position{" +
                "positionId=" + positionId +
                ", positionCategoryId=" + positionCategoryId +
                ", positionCompanyId=" + positionCompanyId +
                ", positionName='" + positionName + '\'' +
                ", positionQuantity=" + positionQuantity +
                ", positionDescription='" + positionDescription + '\'' +
                ", positionSalaryDown=" + positionSalaryDown +
                ", positionSalaryUp=" + positionSalaryUp +
                ", positionCity='" + positionCity + '\'' +
                ", positionAddress='" + positionAddress + '\'' +
                '}';
    }
}