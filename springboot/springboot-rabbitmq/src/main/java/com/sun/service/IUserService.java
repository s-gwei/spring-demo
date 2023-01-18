package com.sun.service;

import com.sun.pojo.User;

import java.util.List;

public interface IUserService {
//    void save(User user);

    List<User> selectUser();

    void save(User user);
}
