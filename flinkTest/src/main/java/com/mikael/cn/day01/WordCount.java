package com.mikael.cn.day01;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

//批处理world count
public class WordCount {
    public static void main(String[] args) throws Exception {
        //创建执行环境
        ExecutionEnvironment environment = ExecutionEnvironment.getExecutionEnvironment();
        //从文件中读取数据
        String path = "C:\\2Code\\zb\\flinkTest\\src\\main\\resources\\hello.txt";
        DataSet<String> stringDataSource = environment.readTextFile(path);

        //对数据集进行处理   按空格分词展开，转化成(world,1 )二元组
        DataSet<Tuple2<String, Integer>> result = stringDataSource.flatMap(new MyflatMapper()).
                groupBy(0) //按照第一个位置的world分组
                .sum(1);//将二个位置上的数据求和
        result.print();

    }

    //自定义类，实现flagMapFUnction
    public static class MyflatMapper implements FlatMapFunction<String, Tuple2<String, Integer>> {

        @Override
        public void flatMap(String value, Collector<Tuple2<String, Integer>> out) throws Exception {
            //按空格分词
            String[] s = value.split(" ");
            //遍历所有world，包成二元组输出
            for (String world : s) {
               out.collect( new Tuple2<>(world,1));
            }


        }
    }


}
