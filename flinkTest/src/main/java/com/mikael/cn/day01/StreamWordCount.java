package com.mikael.cn.day01;


import org.apache.flink.api.common.RuntimeExecutionMode;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;


public class StreamWordCount {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);
        env.setRuntimeMode(RuntimeExecutionMode.AUTOMATIC);
        String path = "C:\\2Code\\2BackendCode\\zb\\flinkTest\\src\\main\\java\\com\\mikael\\cn\\day01\\hello.txt";
        //DataStream<String> stringDataStreamSource = env.socketTextStream("localhost",8888);
        DataStream<String> stringDataStreamSource = env.readTextFile(path);

        DataStream<Tuple2<String, Integer>> sum = stringDataStreamSource.flatMap(new WordCount.MyflatMapper()).keyBy(0).sum(1).filter(x -> x.f1 > 2);

//iii
        sum.print().setParallelism(1);
        env.execute();
    }

}
