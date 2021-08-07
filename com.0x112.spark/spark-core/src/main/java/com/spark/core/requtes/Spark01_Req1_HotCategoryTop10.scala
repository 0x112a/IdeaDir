package com.spark.core.requtes

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark01_Req1_HotCategoryTop10 {
  def main(args: Array[String]): Unit = {

    val dataFile = "datas/user_visit_action.txt"

    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("request1")

    val sc: SparkContext = new SparkContext(sparkConf)

    val datasRDD: RDD[String] = sc.textFile(dataFile)

//    val mapdatasRDD: RDD[Array[String]] = datasRDD.map(
//      line => {
//        line.split("_")
//      }
//    )
    val mapdatasRDD = datasRDD.map(_.split("_"))

    val filterClickIdRdd = mapdatasRDD.filter(
      arr => {
        if (arr(6) != "-1") true else false
      }
    )

    val reduceClick: RDD[(String, Int)] = filterClickIdRdd.map(
      arr => {
        (arr(6), 1)
      }
    ).reduceByKey(_ + _)

    val sortClickIdRdd: RDD[(String, Int)] = reduceClick.sortBy(
      arr => {
        arr._2
      },
      false
    )

    sortClickIdRdd.map(
      arr => {
        arr._1+" @||@ "+arr._2
      }
    ).take(10).foreach(println)


    sc.stop()

    standardAns
  }

  def standardAns = {

    val dataFile = "datas/user_visit_action.txt"
    val hotCategoryTop1 = new SparkConf().setMaster("local[*]").setAppName("HotCategoryTop10")
    val sc = new SparkContext(hotCategoryTop1)

    val datumRDD = sc.textFile(dataFile)

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

    val OrderSumRDD: RDD[(String, Int)] = faltOrderRDD.map((_, 1)).reduceByKey(_ + _)



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

    val cogroupRDD: RDD[(String, (Iterable[Int], Iterable[Int], Iterable[Int]))] = clickSumRDD.cogroup(OrderSumRDD, paySumRDD)

    val analysisRDD: RDD[(String, (Int, Int, Int))] = cogroupRDD.mapValues {
      case (clickIter, orderIter, payIter) => {
        var clickSum = 0
        val iterator1: Iterator[Int] = clickIter.iterator
        if (iterator1.hasNext) clickSum += iterator1.next()
        var orderSum = 0
        val iterator2: Iterator[Int] = orderIter.iterator
        if (iterator2.hasNext) orderSum += iterator2.next()
        var paySum = 0
        val iterator3: Iterator[Int] = payIter.iterator
        if (iterator3.hasNext) paySum += iterator3.next()

        (clickSum, orderSum, paySum)
      }
    }

    val resultRDD = analysisRDD.sortBy(_._2, false).take(10)

    resultRDD.foreach(println)



    sc.stop()
  }
}
