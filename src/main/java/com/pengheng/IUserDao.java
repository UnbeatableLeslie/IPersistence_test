package com.pengheng;

import com.pengheng.pojo.User;

import java.util.List;

/**
 * @project IPersistence_test
 * @remark
 * @Author Administrator
 * @date 2020/10/24
 */
public interface IUserDao {

    List<User> findAll();

    User selectOne(User user);

    int insertUser(User user);

    int deleteById(User user);

    int updateUser(User user);


}
