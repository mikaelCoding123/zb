package com.esdemo.demo.controller;

import com.esdemo.bean.Book;
import com.esdemo.util.ESQueryHelper;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.ElasticsearchClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.eql.EqlSearchRequest;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.lang.ref.PhantomReference;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@RestController
public class DemoController {

    @Resource
    private ElasticsearchRestTemplate restTemplate;

    @PostMapping("/es")
    public Object get() {
//  查看book索引是否存在
//        boolean target = restTemplate.indexOps(IndexCoordinates.of("book")).exists();
//       删除book索引下id为1的数据
//        restTemplate.delete("1", IndexCoordinates.of("book"));
//
        IndexQuery indexQuery = new IndexQuery();
        Book book = new Book();
        book.setAuther("谭三");
        book.setDate("2022-12-22");
        book.setTitle("剪辑");
        book.setWord_count("700");
        indexQuery.setId("21");
        indexQuery.setObject(book);
        String book1 = restTemplate.index(indexQuery, IndexCoordinates.of("book"));
        return book1;
    }

    @PostMapping("/queryOne")
    public Object queryOne(){
        Pageable pageable= PageRequest.of(0,10);
        NativeSearchQueryBuilder builder=new NativeSearchQueryBuilder();
        //根据
//        NativeSearchQuery query=builder.withQuery(QueryBuilders.queryStringQuery("谭三"))
//                .withPageable(pageable)
//                .build();

        NativeSearchQuery query=builder.withQuery(QueryBuilders.queryStringQuery("三"))
                .withPageable(pageable)
                .build();
        SearchHits<Book> search = restTemplate.search(query, Book.class);
        search.forEach(value->{
            System.out.println(value.toString());
        });

        return search;
    }
    @PostMapping("ESQuery/gt")
    public void gt(){
        NativeSearchQuery gt = (NativeSearchQuery)ESQueryHelper.gt("book", "2");

        System.out.println("======");
    }
}
