package com.extra.model;

/**
 * Created by Extra on 2017/8/15.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
public class Message <T>{
    private  long  adminID;
    private  String userName;
    private  String msgType;
    private  T data;

    public long getAdminID() {
        return adminID;
    }

    public void setAdminID(long adminID) {
        this.adminID = adminID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
