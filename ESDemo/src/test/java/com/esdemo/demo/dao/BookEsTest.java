package com.esdemo.demo.dao;

import com.esdemo.demo.bo.Book;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;

import javax.annotation.Resource;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import static org.elasticsearch.index.query.QueryBuilders.queryStringQuery;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BookEsTest {
    @Resource
    public BookEs bookEs;
    @Resource
    private ElasticsearchRestTemplate restTemplate;

    @Test
    public void test01(){
        //保存
        Book book = new Book();
        book.setId("212");
        book.setTitle("昨天");
        book.setAuther("李四");
        bookEs.save(book);
        System.out.println();
    }

    //根据book id 来查询
    @Test
    public void test02(){
        //保存
        Book book = new Book();
        book.setId("212");
        Optional<Book> byId = bookEs.findById("212");
        System.out.println(byId.get());
    }
    //根据book 中的auther来查
    @Test
    public void test03(){
        Book book = new Book();
        book.setAuther("谭三");
        List<Book> auther = bookEs.findBookByAuther("谭三");
        Iterator<Book> iterator = auther.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
    }

    //根据book 中的auther来查
    @Test
    public void test04(){
        List<Book> bookByAutherAndTitle = bookEs.findBookByAutherAndTitle("谭三", "剪辑", Pageable.unpaged());
        Iterator<Book> iterator = bookByAutherAndTitle.iterator();
        while (iterator.hasNext()){
            iterator.next().toString();
        }
    }

    @Test
    public void test001(){
        String word = "12";

        //使用queryStringQuery完成单字符串查询
//        QueryBuilders searchQuery = new NativeSearchQueryBuilder().withQuery(queryStringQuery(word)).withPageable(pageable).build();
//        restTemplate.queryForList(searchQuery, Post.class);


    }
}