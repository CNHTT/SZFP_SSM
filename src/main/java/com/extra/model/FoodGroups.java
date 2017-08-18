package com.extra.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * Created by Extra on 2017/8/16.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
public class FoodGroups {
    private Long id;
    private Long adminID;
    private String className;

    private List<FoodItem> items;

    private String  isDelete;

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date createTime;
    public Long getId() {
        return id;
    }


    public List<FoodItem> getItems() {
        return items;
    }

    public void setItems(List<FoodItem> items) {
        this.items = items;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAdminID() {
        return adminID;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setAdminID(Long adminID) {
        this.adminID = adminID;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
