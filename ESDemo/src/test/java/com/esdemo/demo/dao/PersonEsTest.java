package com.esdemo.demo.dao;

import com.esdemo.demo.bo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonEsTest {

    @Resource
    private PersonEs personEs;

    @Test
    public void test01() {
        double lat = 39.929986;
        double lon = 116.395645;

        List<Person> personList = new ArrayList<>(900000);
        for (int i = 100000; i < 1000000; i++) {
            double max = 0.00001;
            double min = 0.000001;
            Random random = new Random();
            double s = random.nextDouble() % (max - min + 1) + max;
            DecimalFormat df = new DecimalFormat("######0.000000");
            // System.out.println(s);
            String lons = df.format(s + lon);
            String lats = df.format(s + lat);
            Double dlon = Double.valueOf(lons);
            Double dlat = Double.valueOf(lats);

            Person person = new Person();
            person.setId(i);
            person.setName("名字" + i);
            person.setPhone("电话" + i);
            person.setAddress(dlat + "," + dlon);

            personEs.save(person);
        }
//        personEs.saveAll(personList);
    }

    @Test
    public void test02() {
        Optional<Person> byId = personEs.findById("100375");//通过id查找
        Person person = new Person();

        System.out.println(byId.get());
    }


}