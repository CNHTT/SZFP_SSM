package com.extra.model;


import com.extra.utils.TimeUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by 戴尔 on 2017/7/12.
 */
public class User {
    private Long id;
    private String userName;
    private String userPhone;
    private String userEmail;
    private String userPwd;
    private String pwdSalt;
    private String site;
    private String cookie;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date createTime;
    private Date modifyTime;
    private String strTime;
    private String uniqueNumber;

    private String UUID;

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getUniqueNumber() {
        return uniqueNumber;
    }

    public void setUniqueNumber(String uniqueNumber) {
        this.uniqueNumber = uniqueNumber;
    }

    public String getStrTime() {
        return TimeUtils.date2String(createTime);
    }

    public void setStrTime(String strTime) {
        this.strTime = strTime;
    }

    private Short isDelete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getPwdSalt() {
        return pwdSalt;
    }

    public void setPwdSalt(String pwdSalt) {
        this.pwdSalt = pwdSalt;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Short getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Short isDelete) {
        this.isDelete = isDelete;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", pwdSalt='" + pwdSalt + '\'' +
                ", cookie='" + cookie + '\'' +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", strTime='" + strTime + '\'' +
                ", isDelete=" + isDelete +
                '}';
    }
}
