package com.mikael.cn.day01;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.KeyedStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;
//有界流读取文件
public class KeyStreamWordCount {
    public static void main(String[] args) throws Exception {

        StreamExecutionEnvironment environment = StreamExecutionEnvironment.getExecutionEnvironment();
        //environment.setParallelism(4);
        String path = "C:\\2Code\\2BackendCode\\zb\\flinkTest\\src\\main\\java\\com\\mikael\\cn\\day01\\hello.txt";
        DataStream<String> stringDataStreamSource = environment.readTextFile(path);
        //切分，转换，分组，聚合
        SingleOutputStreamOperator<Tuple2<String, Integer>> tuple2SingleOutputStreamOperator = stringDataStreamSource.flatMap(new FlatMapFunction<String, Tuple2<String, Integer>>() {
            @Override
            public void flatMap(String s, Collector<Tuple2<String, Integer>> out) throws Exception {
                String[] s1 = s.split(" ");
                for (String s2 : s1) {
                    //通过收集器向下转发
                    out.collect(new Tuple2<>(s2, 1));
                }

            }
        });
        //分组
        KeyedStream<Tuple2<String, Integer>, String> wordAndOneKs = tuple2SingleOutputStreamOperator.keyBy(new KeySelector<Tuple2<String, Integer>, String>() {

            @Override
            public String getKey(Tuple2<String, Integer> stringIntegerTuple2) throws Exception {
                return stringIntegerTuple2.f0;
            }
        });
        //聚合


        SingleOutputStreamOperator<Tuple2<String, Integer>> sum = wordAndOneKs.sum(1);

        sum.print();
        //执行
        environment.execute();
    }

}
