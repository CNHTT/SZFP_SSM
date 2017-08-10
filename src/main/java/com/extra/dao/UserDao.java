package com.extra.dao;

import com.extra.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by 戴尔 on 2017/7/12.
 */
@Repository
public interface UserDao {
    int     insertUser(User user);
    User selectUserById(@Param("userId")Long userID);
    User selectUserByPhoneOrEmail(@Param("emailOrPhone") String emailOrPhone, @Param("state") Short state);
    List<User> selectAllUser();
    User selectUserByLogin(@Param("nameOrEmail")String nameOrEmail,@Param("password")String pass);
    int   selectCount();
    int   insertOperator(Map<String,String> map);
}
