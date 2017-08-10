package com.extra.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by Extra on 2017/8/10.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
public class Operator {
    private  Long  id;
    private  Long adminID;
    private  String operatorName;
    private  String operatorEmail;
    private  String operatorPhone;
    private  String operatorPwd;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date operatorCreateTime;
    private String  isDelete;
    private String  operatorNumber;

    private OtherInformation  otherInfo;

    public OtherInformation getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(OtherInformation otherInfo) {
        this.otherInfo = otherInfo;
    }

    public Long getID() {
        return id;
    }

    public void setID(Long id) {
        this.id = id;
    }

    public Long getAdminID() {
        return adminID;
    }

    public void setAdminID(Long adminID) {
        this.adminID = adminID;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getOperatorEmail() {
        return operatorEmail;
    }

    public void setOperatorEmail(String operatorEmail) {
        this.operatorEmail = operatorEmail;
    }

    public String getOperatorPhone() {
        return operatorPhone;
    }

    public void setOperatorPhone(String operatorPhone) {
        this.operatorPhone = operatorPhone;
    }

    public String getOperatorPwd() {
        return operatorPwd;
    }

    public void setOperatorPwd(String operatorPwd) {
        this.operatorPwd = operatorPwd;
    }

    public Date getOperatorCreateTime() {
        return operatorCreateTime;
    }

    public void setOperatorCreateTime(Date operatorCreateTime) {
        this.operatorCreateTime = operatorCreateTime;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public String getOperatorNumber() {
        return operatorNumber;
    }

    public void setOperatorNumber(String operatorNumber) {
        this.operatorNumber = operatorNumber;
    }
}
