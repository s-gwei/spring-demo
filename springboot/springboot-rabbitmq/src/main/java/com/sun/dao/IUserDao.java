package com.sun.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sun.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserDao extends BaseMapper<User> {

    User selectUser();
}
