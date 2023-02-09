package com.sun;

import com.sun.mapper.UserMapper;
import com.sun.pojo.User;
import com.sun.session.SqlSession;
import com.sun.session.SqlSessionFactory;

import java.io.IOException;
import java.util.List;

/**
 *
 * （一）、创建 SqlSessionFactory 实例。
 *
 * （二）、实例化过程，加载配置文件创建 Configuration 对象。
 *
 * （三）、通过 factory 创建 SqlSession。
 *
 * （四）、通过 SqlSession 获取 mapper 接口动态代理。
 *
 * （五）、动态代理回调 SqlSession 中某查询方法。
 *
 * （六）、SqlSession 将查询方法转发给 Executor。
 *
 * （七）、Executor 基于 JDBC 访问数据库获取数据。
 *
 * （八）、Executor 通过反射将数据转换成 POJO并返回给 SqlSession。
 *
 * （九）、将数据返回给调用者。
 */
public class TestMybaits {
    public static void main(String[] args) {
        //创建SqlSessionFactory工厂，连接数据库
        SqlSessionFactory factory = new SqlSessionFactory();
        //调用openSession，创建一次连接，SqlSession操作数据库
        SqlSession session = factory.openSession();
        System.out.println(session);
        //获取mapper接口
        UserMapper mapper = session.getMapper(UserMapper.class);

//        List<User> user = mapper.findUserList();
//        mapper.findUserList();
        for(int i=0;i<10;i++){
            User user = new User();
            user.setUserId(i);
            user.setUserName("张三"+i);
            user.setSex(0);
            user.setRole("会员");
            mapper.insertUser(user);
            System.out.println(user.toString());
        }

    }
}
