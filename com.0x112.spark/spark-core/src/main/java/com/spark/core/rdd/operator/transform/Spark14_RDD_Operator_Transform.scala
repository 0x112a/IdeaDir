package com.spark.core.operator.transform

import org.apache.spark.{HashPartitioner, SparkConf, SparkContext}

object Spark14_RDD_Operator_Transform {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(sparkConf)

    //Key-value
    val rdd = sc.makeRDD(List(1, 2, 3, 4))
    val map = rdd.map((_, 1))

    //隐式转换，也就是二次编译
    map.partitionBy(new HashPartitioner(2)).saveAsTextFile("output")


    sc.stop()
  }

}
