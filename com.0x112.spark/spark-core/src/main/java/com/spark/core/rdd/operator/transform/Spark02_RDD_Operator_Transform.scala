package com.spark.core.rdd.operator.transform

import org.apache.spark.{SparkConf, SparkContext}

object Spark02_RDD_Operator_Transform {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(sparkConf)

    val rdd = sc.makeRDD(List(1, 2, 3, 4, 5),2)

    //把一个分区的数据一次拿过来，然后再做处理 以分区为单位处理数据
    // 但是会将数据全部加载到内存中 ，有内存溢出的可能行
    //
    val mapRDD = rdd.mapPartitions(
      iter => {
        println(">>>>>>>>>")
        iter.map(_ * 2)
      }
    )


    mapRDD.collect().foreach(println)

    sc.stop()
  }

}
