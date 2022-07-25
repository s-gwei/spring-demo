package com.sun.controller;


import com.sun.entity.User;
import com.sun.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author astupidcoder
 * @since 2022-07-17
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private IUserService userService;
    /**测试通过mybaits-plus组件查询数据库*/
    @GetMapping("/getUser")
    public User getUser(){
        return userService.getById(1);
    }

    @GetMapping("/findAllUser")
    public List<User> findAllUser(){
        return userService.findAllUser();
    }

    @PostMapping
    public boolean createUser(){
        List<User> userList = new ArrayList<>();
        log.info("save  user");
        for(int i=0;i<10000;i++){
            userList.add(new User(10000+i, "sungw"+i));
        }
        log.info("save 10000 user");
        return userService.saveBatch(userList);
    }

}
