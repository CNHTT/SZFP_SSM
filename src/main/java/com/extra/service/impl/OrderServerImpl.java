package com.extra.service.impl;

import com.extra.dao.OrderDao;
import com.extra.model.FoodGroups;
import com.extra.model.FoodItem;
import com.extra.model.response.ResponsePage;
import com.extra.service.OrderService;
import com.extra.utils.BeanUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Extra on 2017/8/16.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class OrderServerImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Override
    public boolean insertFoodGroups(FoodGroups foodGroups) {
        return false;
    }

    @Override
    public boolean insertFoodGroupsList(List<FoodGroups> foodGroups) {
        return false;
    }

    @Override
    public boolean insertFoodItem(FoodItem foodItem) {
        return false;
    }

    @Override
    public boolean insertFoodItemList(List<FoodItem> foodItems) {
        return false;
    }

    @Override
    public List<FoodGroups> getAllFoodGroups(Long adminID) {
        return orderDao.getAllFoodGroups(adminID);
    }

    @Override
    public List<FoodGroups> getAllFood(Long adminID) {
        return orderDao.getAllFood(adminID);
    }

    @Override
    public List<FoodItem> getFoodItemForGroups(Long groupID) {
        return orderDao.getFoodItemForGroups(groupID);
    }

    @Override
    public ResponsePage<FoodItem> queryByPage(Integer pageNo, Integer pageSize, Long adminID) {
        pageNo      = pageNo ==null?1:pageNo;
        pageSize    = pageSize ==null?5 :pageSize;
        PageHelper.startPage(pageNo,pageSize);
        return BeanUtils.toResponseResult(orderDao.getShopItem(adminID));
    }
}
