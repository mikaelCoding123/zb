package com.mikael.cn.day01;


import org.apache.flink.api.java.ExecutionEnvironment;

public class StreamWordCount {
    public static void main(String[] args) {
        ExecutionEnvironment executionEnvironment = ExecutionEnvironment.getExecutionEnvironment();
        executionEnvironment.setParallelism(4);
        String path = "D:\\6zb\\flinkTest\\src\\main\\java\\com\\mikael\\cn\\day01\\hello.txt";

        executionEnvironment.readTextFile(path);


    }

}
