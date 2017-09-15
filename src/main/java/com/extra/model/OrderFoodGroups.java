package com.extra.model;

import java.util.List;

/**
 * Created by Extra on 2017/9/15.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
public class OrderFoodGroups {

    private Long id;
    private Long adminID;
    private String className;
    private List<OrderItemInfo> item;

    public List<OrderItemInfo> getItem() {
        return item;
    }

    public void setItem(List<OrderItemInfo> item) {
        this.item = item;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAdminID() {
        return adminID;
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
