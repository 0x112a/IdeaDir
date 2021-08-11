package com.spark.core.test

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object gpsTest {

  def main(args: Array[String]): Unit = {

    val gpsFile = "datas/1.txt"

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("gps")
    val sc = new SparkContext(sparkConf)

    val sourceData = sc.textFile(gpsFile)

    val map1Source = sourceData.map(
      line => {
        val datas = line.split(",")
        (datas(1), line)
      }
    )

    val groupRDD: RDD[(String, Iterable[String])] = map1Source.groupByKey()

    val mapGroupRDD: RDD[(String, Int)] = groupRDD.map(
      data => {
        (data._1, 1)
      }
    )
    val result = mapGroupRDD.reduceByKey(_ + _)

    result.saveAsTextFile("output")



    sc.stop()
  }

}
