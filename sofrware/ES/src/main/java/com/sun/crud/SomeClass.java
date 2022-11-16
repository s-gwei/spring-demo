package com.sun.crud;

import com.sun.task.impl.ConnectElasticsearch;

/**
 * @description: lambda
 * @author: sungw
 * @create: 2022-11-15 15:28
 **/
public class SomeClass {
    public static void main(String[] args) {
        ConnectElasticsearch.connect(client -> {
            //do something
        });
    }
}
