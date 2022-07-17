package com.sun.service.impl;

import com.sun.dao.IUserDao;
import com.sun.pojo.User;
import com.sun.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: user service impl
 * @author: sungw
 * @create: 2022-07-17 12:05
 **/
@Service
@Slf4j
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public void save(User user) {
        userDao.insert(user);
    }

    @Override
    public User selectUser() {

        return userDao.selectUser();
    }
}
