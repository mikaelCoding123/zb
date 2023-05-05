package com.demo.web;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.annotation.Resource;

@SpringBootTest(classes = {Demo1Application_10000.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class Demo1ApplicationTests {
    @Resource
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
    }

    @Test
    public void mockMvc_01() throws Exception {

    }


}
