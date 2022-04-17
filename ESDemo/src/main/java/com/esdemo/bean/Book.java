package com.esdemo.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;

@Getter
@Setter
@Data
@Document(indexName = "book")
public class Book implements Serializable {
    @Id
    private Integer id;
    @Field("titile")
    private String title;
    @Field("auther")
    private String auther;
    @Field("word_count")
    private String word_count;
    @Field("date")
    private Object date;
}
