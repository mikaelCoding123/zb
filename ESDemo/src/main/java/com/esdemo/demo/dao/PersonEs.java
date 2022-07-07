package com.esdemo.demo.dao;

import com.esdemo.demo.bo.Person;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface PersonEs extends ElasticsearchRepository<Person, String> {
}
