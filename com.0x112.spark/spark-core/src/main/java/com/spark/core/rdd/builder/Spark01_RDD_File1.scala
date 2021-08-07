package com.spark.core.rdd.builder

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark01_RDD_File1 {

  def main(args: Array[String]): Unit = {
    // 准备环境

    val sparkconf = new SparkConf().setMaster("local[*]").setAppName("RDD")
    val sc = new SparkContext(sparkconf)

    // 创建RDD
    //指定文件
//    val rdd: RDD[String] = sc.textFile("/home/monica/IdeaProjects/com.0x112.spark/datas/2.txt")
    //制定目录(可选通配符）
//    val rdd: RDD[String] = sc.textFile("/home/monica/IdeaProjects/com.0x112.spark/datas/*.txt")
    //从hdfs上读取文件
//    val rdd: RDD[String] = sc.textFile("hdfs://master:8020/gis/gpsTest")
    //从文件中创建RDD，将文件中的数据作为处理的数据源
    //textFile 以行为单位来读取数据，读取的数据都是字符串
    //wholeTextFile 以文件为单位读取数据
    val rdd = sc.wholeTextFiles("hdfs://master:8020/gis/gpsTest")


    rdd.collect().foreach(println)
    // 关闭环境

    sc.stop()

  }

}
