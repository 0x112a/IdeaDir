package com.spark.core.operator.transform

import org.apache.spark.{SparkConf, SparkContext}

object Spark04_RDD_Operator_Transform1 {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(sparkConf)

    val rdd = sc.makeRDD(List("hello world","hello scala"))

    val flatMapRdd = rdd.flatMap(_.split(" "))


    flatMapRdd.collect().foreach(println)

    sc.stop()
  }

}
