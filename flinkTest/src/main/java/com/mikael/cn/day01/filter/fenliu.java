package com.mikael.cn.day01.filter;

import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

//filter简单使用
public class fenliu {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);
        String path = "Z:\\zb\\flinkTest\\src\\main\\java\\com\\mikael\\cn\\day01\\String.txt";
        DataStream<String> stringDataStreamSource = env.readTextFile(path);

        stringDataStreamSource.filter(value -> Integer.valueOf(value) % 2 == 0).print("偶数");
        stringDataStreamSource.filter(value -> Integer.valueOf(value) % 2 == 1).print("奇数");


        env.execute();

    }
}
