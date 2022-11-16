package com.sun.query;

/**
 * @description: 最大值查询
 * @author: sungw
 * @create: 2022-11-15 16:56
 **/
import com.sun.task.ElasticsearchTask;
import com.sun.task.impl.ConnectElasticsearch;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;

public class QueryDoc07 {

    public static final ElasticsearchTask SEARCH_WITH_MAX = client -> {
        // 高亮查询
        SearchRequest request = new SearchRequest().indices("user");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.aggregation(AggregationBuilders.max("maxAge").field("age"));
        //设置请求体
        request.source(sourceBuilder);
        //3.客户端发送请求，获取响应对象
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        //4.打印响应结果
        SearchHits hits = response.getHits();
        System.out.println(response);
    };

    public static void main(String[] args) {
        ConnectElasticsearch.connect(SEARCH_WITH_MAX);
    }

}

