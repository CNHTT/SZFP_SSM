package com.extra.dao;

import com.extra.model.FoodGroups;
import com.extra.model.FoodItem;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Extra on 2017/8/16.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
@Repository
public interface OrderDao {
    int   insertFoodGroups(FoodGroups foodGroups);
    int  insertFoodGroupsList(List<FoodGroups> foodGroups);
    int  insertFoodItem(FoodItem foodItem);
    int  insertFoodItemList(List<FoodItem> foodItems);
    List<FoodGroups> getAllFoodGroups(Long adminID);
    List<FoodGroups> getAllFood(Long adminID);
    List<FoodItem>      getFoodItemForGroups(Long groupID);

    ArrayList<FoodItem> getShopItem(Long adminID);
    long getShopClassID(String className);
}
