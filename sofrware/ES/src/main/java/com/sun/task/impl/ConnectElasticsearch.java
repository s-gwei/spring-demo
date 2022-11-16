package com.sun.task.impl;

import com.sun.task.ElasticsearchTask;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

/**
 * @description: 连接ES
 * @author: sungw
 * @create: 2022-11-15 15:16
 **/
public class ConnectElasticsearch{

    public static void connect(ElasticsearchTask task){
        // 创建客户端对象
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("43.142.160.159", 9200, "http")));
        try {
            task.doSomething(client);
            // 关闭客户端连接
            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
