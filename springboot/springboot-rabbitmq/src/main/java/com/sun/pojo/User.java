package com.sun.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @description: user
 * @author: sungw
 * @create: 2022-07-14 18:32
 **/
@Data
@TableName("t_user")
public class User implements Serializable {

    @TableId(value = "id", type = IdType.AUTO) //表示该id为自增，新增时候不需要手动设置id。
    private int id;


    private String name;

    public User() {
        this.id = id;
        this.name = name;
    }
    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + "]";
    }
}
