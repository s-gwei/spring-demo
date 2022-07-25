package com.sun;

import com.sun.bean.Person;
import com.sun.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @description: 主函数
 * @author: sungw
 * @create: 2022-07-23 13:09
 **/
public class Main {

    public static void main(String[] args) {
//        //获取配置信息
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
//        /**获取bean*/
//        Person bean = applicationContext.getBean(Person.class);
//        System.out.println(bean);
//
//        /**获取配置信息中所有类型为person的bean*/
//        String[] beanTypes = applicationContext.getBeanNamesForType(Person.class);
//        System.out.println(beanTypes.length);
//        for (String name :beanTypes ){
//            System.out.println(name);
//        }
        /**测试包扫描注解*/
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name: beanDefinitionNames){
            System.out.println(name);
        }
    }
}
