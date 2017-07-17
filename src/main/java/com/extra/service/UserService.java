package com.extra.service;

import com.extra.model.User;
import com.extra.model.response.ResponsePage;

import java.util.List;

/**
 * Created by 戴尔 on 2017/7/12.
 */
public interface UserService {
    List<User> getAllUser();
    User getUserByPhoneOrEmail(String  emailOrPone,Short state);
    User getUserById(Long userId);
    ResponsePage<User> queryByPage(Integer pageNo,Integer pageSize);
}