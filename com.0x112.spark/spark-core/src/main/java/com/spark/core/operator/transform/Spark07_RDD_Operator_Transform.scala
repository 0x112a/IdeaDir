package com.spark.core.operator.transform

import org.apache.spark.{SparkConf, SparkContext}

import java.text.SimpleDateFormat

object Spark07_RDD_Operator_Transform {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(sparkConf)

    val rdd = sc.textFile("datas/wwwlogs/blog.0x112.com-access_log")

    val containChrome = rdd.filter(_.contains("Chrome"))

    containChrome.collect().foreach(println)



    sc.stop()
  }

}
