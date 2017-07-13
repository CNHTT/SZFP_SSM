package com.extra.service;

import com.extra.model.User;

/**
 * Created by Extra on 2017/7/13.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
public interface LoginService {
    User getUserInfo(String usernameOremail,String pwd);
}
