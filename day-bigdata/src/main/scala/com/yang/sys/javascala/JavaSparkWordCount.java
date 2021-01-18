package com.yang.sys.javascala;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.api.java.function.VoidFunction;
import org.junit.Test;
import scala.Tuple2;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author yangLongFei 2020-11-26-15:44
 */
public class JavaSparkWordCount implements Serializable {


    @Test
    public void test() {
        System.out.println(1 + 2 + 3);
    }



    @Test
    public void test1() {
        /**
         * conf
         * 	1.可以设置spark的运行模式
         * 	2.可以设置spark在webui中显示的application的名称。
         * 	3.可以设置当前spark application 运行的资源(内存+core)
         *
         * Spark运行模式：
         * 	1.local --在eclipse ，IDEA中开发spark程序要用local模式，本地模式，多用于测试
         *  2.stanalone -- Spark 自带的资源调度框架，支持分布式搭建,Spark任务可以依赖standalone调度资源
         *  3.yarn -- hadoop 生态圈中资源调度框架。Spark 也可以基于yarn 调度资源
         *  4.mesos -- 资源调度框架
         */
        SparkConf sparkConf = new SparkConf();
        sparkConf.setMaster("local");
        sparkConf.setAppName("JavaSparkWordCount");
        /**
         * SparkContext 是通往集群的唯一通道
         */
        JavaSparkContext sc  = new JavaSparkContext(sparkConf);
        /**
         * sc.textFile 读取文件
         */
        JavaRDD<String> lines = sc.textFile("./words");

        /**
         * flatMap 进一条数据出多条数据，一对多关系
         * 第一个参数 传进来的数据
         * 第二个参数 返回的数据类型
         */
        JavaRDD<String> stringJavaRDD = lines.flatMap(new FlatMapFunction<String, String>() {
            private static final long serialVersionUID = -924295000005794846L;

            @Override
            public Iterator<String> call(String s) throws Exception {
                List<String> stringList = Arrays.asList(s.split(" "));
                return stringList.iterator();
            }

        });

        /**
         * 第一个 参数 传进来的数据类型
         * 第二个 参数 返回的 Key 的类型
         * 第三个 参数 返回的 value 的类型
         */
        JavaPairRDD<String, Integer> stringIntegerJavaPairRDD = stringJavaRDD.mapToPair(new PairFunction<String, String, Integer>() {

            @Override
            public Tuple2<String, Integer> call(String s) throws Exception {
                return new Tuple2<>(s, 1);
            }
        });

        JavaPairRDD<String, Integer> stringIntegerJavaPairRDDCount = stringIntegerJavaPairRDD.reduceByKey(new Function2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer integer, Integer integer2) throws Exception {
                return integer + integer2;
            }
        });
        stringIntegerJavaPairRDDCount.foreach(new VoidFunction<Tuple2<String, Integer>>() {
            @Override
            public void call(Tuple2<String, Integer> stringIntegerTuple2) throws Exception {
                System.out.println(stringIntegerTuple2);
            }
        });

        sc.stop();

    }
}
