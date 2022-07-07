package com.esdemo;

import com.esdemo.bean.Book;
import org.apache.tomcat.jni.Local;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.core.Map;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.Query;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.ArrayList;

@SpringBootTest
class EsDemoApplicationTests {

    @Resource
    private ElasticsearchRestTemplate esTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void insert(){
        IndexQuery indexQuery = new IndexQuery();
        Book book = new Book();
        book.setAuther("谭三");
        book.setDate(LocalDate.now());
        book.setTitile("剪辑");
        book.setWord_count("700");
        indexQuery.setId("11");
        indexQuery.setObject(book);
        esTemplate.index(indexQuery, IndexCoordinates.of("book"));
    }
    @Test
    void query(){

        ArrayList<Object> objects = new ArrayList<>();
        IndexQuery indexQuery = new IndexQuery();

    }



}
