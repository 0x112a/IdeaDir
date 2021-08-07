package com.spark.core.operator.transform

import org.apache.spark.{SparkConf, SparkContext}

object Spark01_RDD_Operator_Transform {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(sparkConf)

    val rdd = sc.makeRDD(List(1,2,3,4,5))

    val mapRDD = rdd.map(_ * 2)

    mapRDD.collect().foreach(println)

    sc.stop()
  }

}
