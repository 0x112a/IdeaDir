package com.spark.core.test

import org.apache.spark.rdd.RDD
import org.apache.spark.{SPARK_REVISION, SparkConf, SparkContext}

object gpsTest1 {

  def main(args: Array[String]): Unit = {

//    val gpsFile = "datas/1.txt"
    val gpsFile = "hdfs://master:8020/gis/gps_20161101"

    val sparkConf = new SparkConf().setMaster("spark://master:7077").setAppName("gps")
    val sc = new SparkContext(sparkConf)

    val sourceData = sc.textFile(gpsFile)

    val map1Source = sourceData.map(
      line => {
        val datas = line.split(",")
        (datas(1), datas(0))
      }
    )

    val reduceByKey: RDD[(String, String)] = map1Source.reduceByKey(
      (a,_) =>{
        a
      }
    )

    val value: RDD[(String, Iterable[(String, String)])] = reduceByKey.groupBy(_._2)

    val result = value.map {
      case (a, b) => {
        (a, b.size)
      }
    }

    result.saveAsTextFile("hdfs://master:8020/output")



    sc.stop()
  }

}
