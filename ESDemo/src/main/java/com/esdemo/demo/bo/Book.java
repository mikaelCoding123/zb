package com.esdemo.demo.bo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "book")
@Data
public class Book {
    @Id
    private String id;
    private String title;
    @Field(type = FieldType.Nested,includeInParent = true)
    private String auther;
}
