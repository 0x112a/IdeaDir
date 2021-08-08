package com.spark.core.requtes

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark05_Req1_HotCategoryTop {
  def main(args: Array[String]): Unit = {

    val dataFile = "datas/user_visit_action.txt"
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("request")
    val sc = new SparkContext(sparkConf)

    val dataRDD = sc.textFile(dataFile)
    dataRDD.cache()
    val top10Ids: Array[String] = top10Category(dataRDD)


    val filterTop10Rdd: RDD[String] = dataRDD.filter(
      line => {
        val strings = line.split("_")
        if (strings(6) != "-1") top10Ids.contains(strings(6)) else false
      }
    )

    val sessionClickRDD: RDD[((String, String), Int)] = filterTop10Rdd.map(
      line => {
        val strings = line.split("_")
        ((strings(6), strings(2)), 1)
      }
    ).reduceByKey(_ + _)

    val sessionClickMapRDD: RDD[(String, (String, Int))] = sessionClickRDD.map {
      case (t1, t2) => (t1._1, (t1._2, t2))
    }

    val sissionGroupRDD: RDD[(String, Iterable[(String, Int)])] = sessionClickMapRDD.groupByKey()

    val resultRDD = sissionGroupRDD.mapValues(
      iter => {
        iter.toList.sortBy(_._2)(Ordering.Int.reverse).take(10)
      }
    )

    resultRDD.collect().foreach(println)


    sc.stop()
  }

  def top10Category(actionRDD: RDD[String]) = {
    val flatRDD: RDD[(String, (Int, Int, Int))] = actionRDD.flatMap(
      data => {
        val datas = data.split("_")
        if (datas(6) != "-1") {
          //为了返回值统一，设置为List
          List((datas(6), (1, 0, 0)))
        } else if (datas(8) != "null") {
          val ids = datas(8).split(",")
          ids.map((_, (0, 1, 0)))
        } else if (datas(10) != "null") {
          val ids = datas(10).split(",")
          ids.map((_, (0, 0, 1)))
        } else {
          Nil
        }
      }
    )

    val analysisRDD = flatRDD.reduceByKey(
      (t1, t2) => {
        (t1._1 + t2._1, t1._2 + t2._2, t1._3 + t2._3)
      }
    )

    analysisRDD.sortBy(_._2,false).take(10).map(_._1)

  }

}
