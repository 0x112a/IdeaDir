package com.spark.core.requtes

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark02_Req1_HotCategoryTop10 {
  def main(args: Array[String]): Unit = {

    val dataFile = "datas/user_visit_action.txt"

    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("request1")

    val sc: SparkContext = new SparkContext(sparkConf)

    val datumRDD = sc.textFile(dataFile)

    datumRDD.cache()

    //品类的点击数
    val clickActionRDD = datumRDD.filter(
      line => {
        val datas = line.split("_")
        datas(6) != "-1"
      }
    )

    val clickSumRDD: RDD[(String, Int)] = clickActionRDD.map(
      line => {
        val datas = line.split("_")
        (datas(6), 1)
      }
    ).reduceByKey(_ + _)

    //品类的下单数量
    val orderRDD = datumRDD.filter(
      line => {
        val arrs = line.split("_")
        arrs(8) != "null"
      }
    )

    val faltOrderRDD: RDD[String] = orderRDD.flatMap(
      line => {
        val strings = line.split("_")
        strings(8).split(",")
      }
    )

    val orderSumRDD: RDD[(String, Int)] = faltOrderRDD.map((_, 1)).reduceByKey(_ + _)



    //品类的支付数量

    val payRDD: RDD[(String, Int)] = datumRDD.filter(
      line => {
        val arrs = line.split("_")
        arrs(10) != "null"
      }
    ).flatMap(
      line => {
        val arrs = line.split("_")
        val datas = arrs(10).split(",")
        datas.map((_, 1))
      }
    )
    val paySumRDD = payRDD.reduceByKey(_ + _)

    //合并RDD
    val clickSR = clickSumRDD.map {
      case (key, value) => {
        (key, (value, 0, 0))
      }
    }
    val orderSR = orderSumRDD.map {
      case (key, value) => {}
        (key, (0, value, 0))
    }
    val paySR = paySumRDD.map {
      case (key, value) => {
        (key, (0, 0, value))
      }
    }

    val sourceRDD: RDD[(String, (Int, Int, Int))] = clickSR.union(orderSR).union(paySR)

    val analysisRDD: RDD[(String, (Int, Int, Int))] = sourceRDD.reduceByKey(
      (t1, t2) => {
        (t1._1 + t2._1, t1._2 + t2._2, t1._3 + t2._3)
      }
    )


    val resultRDD = analysisRDD.sortBy(_._2, false).take(10)

    resultRDD.foreach(println)


  }



}