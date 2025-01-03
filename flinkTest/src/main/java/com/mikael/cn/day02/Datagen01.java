package com.mikael.cn.day02;

import com.mikael.cn.water.WaterSensor;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class Datagen01 {
    public static void main(String[] args) throws Exception {

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(3);



        DataStreamSource<WaterSensor> streamSource = env.fromElements(new WaterSensor("1", 11L, 11),
                new WaterSensor("2", 22L, 222), new WaterSensor("3", 33L, 333));
        //方式一
//        SingleOutputStreamOperator<String> map = streamSource.map(data -> data.getId() + " " + data.getTs() + " " + data.getVc());
        //方式二
        SingleOutputStreamOperator<String> map = streamSource.map(new MyMapFunction(){
            @Override
            public String map(WaterSensor value) {
                return value.getId() + " " + value.getTs() + " " + value.getVc();
            }
        });


        map.print();

        env.execute();

    }

}

 class MyMapFunction implements MapFunction<WaterSensor, String> {

    @Override
    public String map(WaterSensor value) throws Exception {
        return value.getId() + " " + value.getTs() + " " + value.getVc();
    }
}
