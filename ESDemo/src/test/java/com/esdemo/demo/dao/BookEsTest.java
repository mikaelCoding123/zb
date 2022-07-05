package com.esdemo.demo.dao;

import com.esdemo.demo.bo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.annotation.Resource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BookEsTest {
    @Resource
    public BookEs bookEs;

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

    @Test
    public void test02(){
        //保存
        Book book = new Book();
        book.setId("212");
        Optional<Book> byId = bookEs.findById("212");
        System.out.println(byId.toString());


    }
}