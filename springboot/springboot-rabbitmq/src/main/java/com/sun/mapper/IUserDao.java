package com.sun.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sun.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IUserDao{

    List<User> selectUser();

    int insert(User user);
}
