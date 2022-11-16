package com.sun.crud;

import java.io.IOException;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

public class HelloElasticsearch {

    public static void main(String[] args) throws IOException {
        // 创建客户端对象
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("43.142.160.159", 9200, "http")));
        System.out.println(client);
        // 关闭客户端连接
        client.close();
    }
}
