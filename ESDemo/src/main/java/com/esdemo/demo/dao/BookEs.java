package com.esdemo.demo.dao;

import com.esdemo.demo.bo.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface BookEs extends ElasticsearchRepository<Book,String> {


}
