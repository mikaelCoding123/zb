package com.mikael.cn.keyby;

import com.mikael.cn.water.ConsumHis;
import org.apache.flink.api.common.functions.ReduceFunction;
import org.apache.flink.streaming.api.datastream.KeyedStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.math.BigDecimal;
import java.util.Date;

public class KeyBy01 {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(3);
        KeyedStream<ConsumHis, String> keyedStream = env.fromElements(
                  new ConsumHis("1", "S1", new Date(1000000), new BigDecimal("1.01"))
                , new ConsumHis("2", "S2", new Date(2000000), new BigDecimal("2.02"))
                , new ConsumHis("3", "S1", new Date(3000000), new BigDecimal("5.05"))
                , new ConsumHis("4", "S3", new Date(4000000), new BigDecimal("3.03"))
        ).keyBy((value) -> value.getName());

        SingleOutputStreamOperator<ConsumHis> reduce = keyedStream.reduce(new ReduceFunction<ConsumHis>() {
            @Override
            public ConsumHis reduce(ConsumHis value1, ConsumHis value2) throws Exception {
                return new ConsumHis(value1.getId(),value1.getName(),value1.getTime(),value1.getPrice().add(value2.getPrice()));
            }
        });


        reduce.print();

        env.execute();

    }
}
