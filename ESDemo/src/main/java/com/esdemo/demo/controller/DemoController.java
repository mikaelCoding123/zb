package com.esdemo.demo.controller;

import com.esdemo.bean.Book;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class DemoController {

    @Resource
    private ElasticsearchRestTemplate restTemplate;


    @PostMapping("/es/add/book")
    public Object get() {
//  查看book索引是否存在
//        boolean target = restTemplate.indexOps(IndexCoordinates.of("book")).exists();
//       删除book索引下id为1的数据
//        restTemplate.delete("1", IndexCoordinates.of("book"));
//
        IndexQuery indexQuery = new IndexQuery();
        Book book = new Book();
        book.setAuther("辑");
        book.setDate("2022-12-22");
        book.setTitile("剪辑");
        book.setWord_count("700");
        indexQuery.setId(UUID.randomUUID().toString());
        indexQuery.setObject(book);
        String book1 = restTemplate.index(indexQuery, IndexCoordinates.of("book"));
        return book1;
    }

    @PostMapping("/queryOne")
    public Object queryOne() {
        Pageable pageable = PageRequest.of(0, 10);
        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();
        //根据
//        NativeSearchQuery query=builder.withQuery(QueryBuilders.queryStringQuery("谭三"))
//                .withPageable(pageable)
//                .build();

        NativeSearchQuery query = builder.withQuery(QueryBuilders.queryStringQuery("三"))
                .withPageable(pageable)
                .build();
        SearchHits<Book> search = restTemplate.search(query, Book.class);
        search.forEach(value -> {
            System.out.println(value.toString());
        });
        return search;
    }

    /**
     * 模糊查看titile字段是否包含 text字段内容
     */
    @PostMapping("ESQuery/matchLikeList")
    public void matchList() {
        Pageable pageable = PageRequest.of(0, 10);
        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();
        NativeSearchQuery query = builder.withQuery(QueryBuilders.matchQuery("titile", "辑"))
                .withPageable(pageable)
                .build();
        SearchHits<Book> search = restTemplate.search(query, Book.class);
        search.forEach(value -> {
            System.out.println(value.toString());
        });
        System.out.println("======");
    }

    /**
     * 单字段对某短语进行匹配查询，短语分词的顺序会影响结果
     */
    @PostMapping("ESQuery/matchPhraseQuery")
    public void matchPhraseQuery() {
        Pageable pageable = PageRequest.of(0, 10);
        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();
        NativeSearchQuery query = builder.withQuery(QueryBuilders.matchPhraseQuery("titile", "剪辑").slop(2))
                .withPageable(pageable)
                .build();
        SearchHits<Book> search = restTemplate.search(query, Book.class);
        search.forEach(value -> {
            System.out.println(value.toString());
        });
        System.out.println("======");
    }

    //multiMatchQuery
    @PostMapping("/es/multi")
    public void multiMatchQuery(){
        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();
        NativeSearchQuery query = builder.withQuery(QueryBuilders.matchPhraseQuery("titile", "辑").slop(2))
                .build();
        NativeSearchQuery query2 = builder.withQuery(QueryBuilders.matchPhraseQuery("auther", "辑").slop(2))
                .build();
        List<Query> queries = new ArrayList<>();
        queries.add(query);
        queries.add(query2);
        List<SearchHits<Book>> search = restTemplate.multiSearch(queries, Book.class);
        search.forEach(value -> {
            System.out.println(value.toString());
        });
        System.out.println("======");

    }

}
