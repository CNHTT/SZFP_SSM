package com.extra.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by Extra on 2017/8/16.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
public class FoodItem {
    private Long    id;
    private Long    adminID;
    private Long    foodGroupsID;
    private String  foodName;
    private String  foodPrice;
    private String  foodInfo;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date createTime;
    public Long getAdminID() {
        return adminID;
    }
    private String  isDelete;
    public Date getCreateTime() {
        return createTime;
    }


    private  String className;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setAdminID(Long adminID) {
        this.adminID = adminID;
    }

    public Long getFoodGroupsID() {
        return foodGroupsID;
    }

    public void setFoodGroupsID(Long foodGroupsID) {
        this.foodGroupsID = foodGroupsID;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(String foodPrice) {
        this.foodPrice = foodPrice;
    }


    public String getFoodInfo() {
        return foodInfo;
    }

    public void setFoodInfo(String foodInfo) {
        this.foodInfo = foodInfo;
    }
}
