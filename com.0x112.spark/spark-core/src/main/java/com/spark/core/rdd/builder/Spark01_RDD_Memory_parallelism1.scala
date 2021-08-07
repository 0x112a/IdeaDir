package com.spark.core.rdd.builder

import org.apache.spark.{SparkConf, SparkContext}

object Spark01_RDD_Memory_parallelism1 {

  def main(args: Array[String]): Unit = {
    // 准备环境

    val sparkconf = new SparkConf().setMaster("local[*]").setAppName("RDD")
    val sc = new SparkContext(sparkconf)

    // 创建RDD
    //关注数据的分区位置
    val rdd = sc.makeRDD(List(1, 2, 3, 4, 5) ,2)


    rdd.saveAsTextFile("./output")
    // 关闭环境

    sc.stop()

  }

}
