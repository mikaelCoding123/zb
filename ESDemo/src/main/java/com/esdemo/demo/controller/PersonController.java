package com.esdemo.demo.controller;

import org.elasticsearch.common.unit.DistanceUnit;
import org.elasticsearch.index.query.GeoDistanceQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.GeoDistanceSortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("person")
@RestController
public class PersonController {
    @Resource
    private ElasticsearchRestTemplate restTemplate;
    //获取100米范围内的人
//    @RequestMapping("range100")
//    public void getRange100(){
//        double lat = 39.929986;
//        double lon = 116.395645;
//
//        Pageable pageable = new PageRequest(0, 10);
//        Long nowTime = System.currentTimeMillis();
//        //查询某经纬度100米范围内
//        GeoDistanceQueryBuilder builder = QueryBuilders.geoDistanceQuery("address").point(lat, lon)
//                .distance(100, DistanceUnit.METERS);
//
//        GeoDistanceSortBuilder sortBuilder = SortBuilders.geoDistanceSort("address")
//                .point(lat, lon)
//                .unit(DistanceUnit.METERS)
//                .order(SortOrder.ASC);
//
//        NativeSearchQueryBuilder builder1 = new NativeSearchQueryBuilder();
//        NativeSearchQuery build = builder1.withQuery(builder1).withPageable(pageable).build();
////        SearchQuery searchQuery = builder1.build();
//        //queryForList默认是分页，走的是queryForPage，默认10个
//        SearchHits<Person> search = restTemplate.search(build, Person.class);
//        System.out.println("耗时：" + (System.currentTimeMillis() - nowTime));
//
//    }

}
