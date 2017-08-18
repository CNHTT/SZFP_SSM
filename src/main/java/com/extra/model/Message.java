package com.extra.model;

/**
 * Created by Extra on 2017/8/15.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
public class Message <T>{
    private  long  id;
    private  String type;
    private  T data;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
