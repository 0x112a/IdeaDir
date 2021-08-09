package com.spark.core.operator.transform

import org.apache.spark.{SparkConf, SparkContext}

object Spark01_RDD_Operator_Transform_logUrl {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(sparkConf)

    val rdd = sc.textFile("datas/wwwlogs/www.0x112.com-access_log")

    val mapRDD = rdd.map(
      line => {
        val data = line.split(" ")
        data(6)
      }
    )

    mapRDD.collect().take(10).foreach(println)

    sc.stop()
  }

}
