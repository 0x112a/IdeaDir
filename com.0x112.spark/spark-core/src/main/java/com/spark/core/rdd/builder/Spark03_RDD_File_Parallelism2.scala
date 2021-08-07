package com.spark.core.rdd.builder

import org.apache.spark.{SparkConf, SparkContext}

object Spark03_RDD_File_Parallelism2 {

  def main(args: Array[String]): Unit = {
    // 准备环境

    val sparkconf = new SparkConf().setMaster("local[*]").setAppName("RDD")
    val sc = new SparkContext(sparkconf)

    // TODO 数据分区的分配
    // 1. 数据以行为单位进行读取
    //    spark读取文件，采用的是hadoop的方式读取，所以一行一行读取，和字节数没有关系
    // 2. 数据读取时以偏移量为单位,偏移量不会被重复读取
    /* @表示回车换行
       1@@   => 012
       2@@   => 345
       3     => 6

     */

    // 3. 数据分区的偏移量范围的计算
    /**
     *  Hello World
        Hello Spark
        hello world

     37Byte / 2 Parallelism = 18 Byte..1 --- 3分区
     [0,18]
     [18,36]
     [36,37]
     */


    val rdd = sc.textFile("datas/1.txt", 2)

    rdd.saveAsTextFile("output")
    // 关闭环境

    sc.stop()

  }

}
