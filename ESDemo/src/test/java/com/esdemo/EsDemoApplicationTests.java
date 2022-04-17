package com.esdemo;

import com.esdemo.bean.Book;
import org.apache.tomcat.jni.Local;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.joda.time.LocalTime;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.IndexQuery;

import javax.annotation.Resource;

@SpringBootTest
class EsDemoApplicationTests {

    @Resource
    private ElasticsearchRestTemplate restTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void insert(){
        IndexQuery indexQuery = new IndexQuery();
        Book book = new Book();
        book.setAuther("谭三");
        book.setDate(new LocalTime());
        book.setTitle("剪辑");
        book.setWord_count("700");
        indexQuery.setId("11");
        indexQuery.setObject(book);
        restTemplate.index(indexQuery, IndexCoordinates.of("book"));
    }



}
