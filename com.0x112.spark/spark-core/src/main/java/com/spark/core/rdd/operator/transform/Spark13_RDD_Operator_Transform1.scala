package com.spark.core.operator.transform

import org.apache.spark.{SparkConf, SparkContext}

object Spark13_RDD_Operator_Transform1 {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(sparkConf)

    val rdd1 = sc.makeRDD(List(1, 2, 3, 4))
    val rdd2 = sc.makeRDD(List(3, 4, 5, 6))

    //拉链（zip）
    val rdd6 = rdd1.zip(rdd2)
    println(rdd6.collect().mkString(";"))

    sc.stop()
  }

}
