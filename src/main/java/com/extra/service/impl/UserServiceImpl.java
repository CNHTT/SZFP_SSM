package com.extra.service.impl;

import com.extra.dao.UserDao;
import com.extra.model.User;
import com.extra.model.response.ResponsePage;
import com.extra.service.UserService;
import com.extra.utils.BeanUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by 戴尔 on 2017/7/12.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService{

    @Resource
    private UserDao userDao;

    public void insertUsers(Map<String, Object> param) {

    }

    public List<User> getAllUser() {
        return userDao.selectAllUser();
    }

    public User getUserByPhoneOrEmail(String emailOrPone, Short state) {
        return userDao.selectUserByPhoneOrEmail(emailOrPone,state);
    }

    public User getUserById(Long userId) {
        return userDao.selectUserById(userId);
    }

    public ResponsePage<User> queryByPage( Integer pageNo, Integer pageSize) {
        pageNo      = pageNo ==null?1:pageNo;
        pageSize    = pageSize ==null?1 :pageSize;
        PageHelper.startPage(pageNo,pageSize);
        return BeanUtils.toResponseResult((ArrayList<User>) userDao.selectAllUser());
    }

}
