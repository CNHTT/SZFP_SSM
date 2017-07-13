package com.extra.service.impl;

import com.extra.dao.UserDao;
import com.extra.model.User;
import com.extra.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 戴尔 on 2017/7/12.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService{

    @Resource
    private UserDao userDao;

    public List<User> getAllUser() {
        return userDao.selectAllUser();
    }

    public User getUserByPhoneOrEmail(String emailOrPone, Short state) {
        return userDao.selectUserByPhoneOrEmail(emailOrPone,state);
    }

    public User getUserById(Long userId) {
        return userDao.selectUserById(userId);
    }

}
