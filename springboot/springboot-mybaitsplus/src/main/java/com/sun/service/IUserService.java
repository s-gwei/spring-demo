package com.sun.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sun.entity.User;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author astupidcoder
 * @since 2022-07-17
 */
public interface IUserService {

    List<User> findAllUser();
}
