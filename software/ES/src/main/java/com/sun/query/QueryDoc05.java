package com.sun.query;

/**
 * @description: 模糊查询
 * @author: sungw
 * @create: 2022-11-15 16:54
 **/

import com.sun.task.ElasticsearchTask;
import com.sun.task.impl.ConnectElasticsearch;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;

public class QueryDoc05 {

    public static final ElasticsearchTask SEARCH_BY_FUZZY_CONDITION = client -> {
        // 创建搜索请求对象
        SearchRequest request = new SearchRequest();
        request.indices("user");
        // 构建查询的请求体
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(QueryBuilders.fuzzyQuery("name","wangwu").fuzziness(Fuzziness.ONE));
        request.source(sourceBuilder);
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        // 查询匹配
        SearchHits hits = response.getHits();
        System.out.println("took:" + response.getTook());
        System.out.println("timeout:" + response.isTimedOut());
        System.out.println("total:" + hits.getTotalHits());
        System.out.println("MaxScore:" + hits.getMaxScore());
        System.out.println("hits========>>");
        for (SearchHit hit : hits) {
            //输出每条查询的结果信息
            System.out.println(hit.getSourceAsString());
        }
        System.out.println("<<========");
    };


    public static void main(String[] args) {
//        ConnectElasticsearch.connect(SEARCH_ALL);
//        ConnectElasticsearch.connect(SEARCH_BY_CONDITION);
//        ConnectElasticsearch.connect(SEARCH_BY_PAGING);
//        ConnectElasticsearch.connect(SEARCH_WITH_ORDER);
//        ConnectElasticsearch.connect(SEARCH_BY_BOOL_CONDITION);
//        ConnectElasticsearch.connect(SEARCH_BY_RANGE);
        ConnectElasticsearch.connect(SEARCH_BY_FUZZY_CONDITION);
    }

}

