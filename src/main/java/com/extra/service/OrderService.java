package com.extra.service;

import com.extra.model.FoodGroups;
import com.extra.model.FoodItem;
import com.extra.model.GameClass;
import com.extra.model.response.ResponsePage;

import java.util.List;

/**
 * Created by Extra on 2017/8/16.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
public interface OrderService {
    boolean insertFoodGroups(FoodGroups foodGroups);

    boolean insertFoodGroupsList(List<FoodGroups> foodGroups);

    boolean insertFoodItem(FoodItem foodItem);

    boolean insertFoodItemList(List<FoodItem> foodItems);


    List<FoodGroups> getAllFoodGroups(Long adminID);

    List<FoodGroups> getAllFood(Long adminID);

    List<FoodItem> getFoodItemForGroups(Long groupID);

    ResponsePage<FoodItem> queryByPage(Integer pageNumber, Integer pageSize, Long adminID);


    long getClassNameId(String className);

}



