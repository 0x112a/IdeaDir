package com.spark.gps.orderToList.service

import com.spark.gps.orderToList.common.TService
import com.spark.gps.orderToList.dao.WordCountDao
import org.apache.spark.rdd.RDD


class WordCountService extends TService{

  private val wordCountDao = new WordCountDao()

  def dataAnalysis() = {

    // 1. 读取文件，按行
    val lines = wordCountDao.readFile("hdfs://master:8020/gis/gps_20161101")
//    var lines = wordCountDao.readFile("datas/1.txt")

    val value: RDD[(String, (String, String))] = lines.map(s => {

      val datas: Array[String] = s.split(",")
      (datas(1),(datas(3),datas(4)))
    })

    val groupByOrder: RDD[(String, Iterable[(String, (String, String))])] = value.groupBy(data => data._1);

    val orderList: RDD[List[List[String]]] = groupByOrder.map(data => {
      val iterator: Iterator[(String, (String, String))] = data._2.iterator
      val tuples: Iterator[List[String]] = iterator.map(arr => {
        List[String](arr._2._1,arr._2._2)
      })
      tuples.toList
    })

    val orderListRDD: RDD[List[String]] = orderList.map(list => {
      list.flatten
    })


    val orderString: RDD[String] = orderListRDD.map(list => {
      val str: String = list.mkString("[", ",", "],")
      str
    })


//    val orderGlom: RDD[Array[String]] = orderString.repartition(1).glom()
    val orderGlom: RDD[Array[String]] = orderString.glom()

    val orderGlomToList: RDD[String] = orderGlom.map(_.toList.mkString("[","","]"))

    orderGlomToList.saveAsTextFile("hdfs://master:8020/output_9_15")

  }
}
