package com.esdemo.demo.dao;

import com.esdemo.demo.bo.Book;
import jdk.nashorn.internal.runtime.FindProperty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface BookEs extends ElasticsearchRepository<Book,String> {

    List<Book> findBookByAuther(String auther);

    List<Book> findBookByAutherAndTitle(String auther, String title, Pageable pageable);


}
