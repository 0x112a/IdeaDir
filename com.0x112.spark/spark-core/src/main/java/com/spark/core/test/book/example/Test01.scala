package com.spark.core.test.book.example

import org.apache.spark.{SparkConf, SparkContext}


object SimpleApp{
  def main(args: Array[String]): Unit = {
    val GisFile = "hdfs://master:8020/gis/gps_20161101"
//    val GisFile = "hdfs://master:8020/gis/gpsTest"
    val conf = new SparkConf().setMaster("spark://master:7077").setAppName("Simeple Application")
//    val conf = new SparkConf().setMaster("local[2]").setAppName("Simeple Application")

    val sc = new SparkContext(conf)
    val gisData = sc.textFile(GisFile,2)
    val str = gisData.first()
//    val num = gisData.flatMap(_.split(" ")).count()



    println(s"Words in gpsTest is: $str")
    sc.stop()
  }
}