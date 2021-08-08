package com.spark.core.requtes

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


object Spark03_Req1_HotCategoryTop10 {
  def main(args: Array[String]): Unit = {

    val dataFile = "hdfs://master:8020/datas/user_visit_action.txt"

    val sparkConf: SparkConf = new SparkConf().setMaster("spark://master:7077").setAppName("request1")

    val sc: SparkContext = new SparkContext(sparkConf)

    val datumRDD = sc.textFile(dataFile)

    datumRDD.cache()

    val sourceRDD: RDD[(String, (Int, Int, Int))] = datumRDD.flatMap(
      line => {

        val arr = line.split("_")

        if (arr(6) != "-1") {

          List((arr(6), (1, 0, 0)))
        } else if (arr(8) != "null") {
          val ids: Array[String] = arr(8).split(",")
          ids.map(id => (id, (0, 1, 0)))
        } else if (arr(10) != "null") {
          val ids = arr(10).split(",")
          ids.map(id => (id, (0, 0, 1)))
        } else{
          Nil
        }
      }
    )

    val analysisRDD = sourceRDD.reduceByKey {
      case (t1, t2) => {
        (t1._1 + t2._1, t1._2 + t2._2, t1._3 + t2._3)
      }
    }

    val resultRDD = analysisRDD.sortBy(_._2, false).take(10)

    resultRDD.foreach(println)

    sc.stop()

  }



}