package com.sun.mapper;

import com.sun.pojo.User;

import java.util.List;

public interface IUserDao{

    List<User> selectUser();

    int insert(User user);
}
