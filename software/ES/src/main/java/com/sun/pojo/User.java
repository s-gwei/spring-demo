package com.sun.pojo;

/**
 * @description: 实体类
 * @author: sungw
 * @create: 2022-11-15 15:32
 **/
public class User {
    private String Name;

    private Integer age;

    private String Sex;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }
}
