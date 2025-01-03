package com.mikael.cn.keyby;

import com.mikael.cn.water.ConsumHis;
import org.apache.flink.api.common.functions.RichMapFunction;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.math.BigDecimal;
import java.util.Date;


//只是知道RichMapFunction里的几个open和close方法执行的时刻
public class RichFunction01 {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(3);
        SingleOutputStreamOperator<Integer> map1 = env.fromElements(
                new ConsumHis("1", "S1", new Date(1000000), new BigDecimal("1.01"))
                , new ConsumHis("2", "S2", new Date(2000000), new BigDecimal("2.02"))
                , new ConsumHis("3", "S1", new Date(3000000), new BigDecimal("5.05"))
                , new ConsumHis("4", "S3", new Date(4000000), new BigDecimal("3.03"))
        ).map(new RichMapFunction<ConsumHis, Integer>() {
            @Override
            public Integer map(ConsumHis value) throws Exception {
                return Integer.getInteger(value.getPrice().toString());
            }

            @Override
            public void open(Configuration parameters) throws Exception {
                super.open(parameters);
                System.out.println("open");
            }

            @Override
            public void close() throws Exception {
                super.close();
                System.out.println("close");
            }
        });
        map1.print();
        env.execute();


    }
}
