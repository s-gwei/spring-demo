package com.sun.service;

import com.sun.pojo.User;

public interface IUserService {
    void save(User user);

    User selectUser();
}
