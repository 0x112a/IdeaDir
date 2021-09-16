package com.spark.gps.countOrderNumberByEveryDay.service

import com.spark.gps.countOrderNumberByEveryDay.common.TService
import com.spark.gps.countOrderNumberByEveryDay.dao.CountOrderDao
import org.apache.spark.rdd.RDD

class CountOrderService extends TService{

  private val dao = new CountOrderDao
  override def dataAnalysis(): Any = {
//    ./bin/spark-submit --class com.spark.gps.countOrderNumberByEveryDay.application.OrderCountByEveryDayApplication --master yarn --deploy-mode cluster ~/everyCount.jar

    val fileRDD: RDD[(String, String)] = dao.readFile("hdfs://master:8020/gis/gps_20161101")
//    val fileRDD: RDD[(String, String)] = dao.readFile("datas/1.txt")

    val metaDataRdd = fileRDD.map(data => {

      val strings: Array[String] = data._2.split("\n")
      val strings1 = data._1.split("/")
      val strArr = strings.map(_ + "," + strings1(strings1.length - 1))
      strArr.toList

    }).flatMap(list => list)

    val everyRdd = metaDataRdd.map(data => {
      val strings = data.split(",")
      strings(1) +","+ strings(strings.length - 1)
    }).distinct()


    val everyDayCount = everyRdd.map(data => {
      val strings = data.split(",")
      (strings(1), 1)
    }).reduceByKey(_ + _)

//scheduler.TaskSetManager: Lost task 0.3 in stage 0.0 (TID 5) (172.21.3.211 executor 4): java.lang.OutOfMemoryError: Java heap space
    everyDayCount.saveAsTextFile("hdfs://master:8020/everyDayCounts")

//    val tuples: Array[(String, Int)] = everyDayCount.collect()
//    tuples


  }
}
