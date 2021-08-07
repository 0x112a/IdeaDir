package com.spark.core.operator.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark24_RDD_Req {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(sparkConf)

    //eg real operator
    //获取数据
    val datasRDD = sc.textFile("datas/agent.log")

    //将数据转换
    val mapRDD = datasRDD.map(
      line => {
        val data = line.split(" ")
        ((data(1), data(4)), 1)
      }
    )

    //进行分组聚合
    val reduceRDD = mapRDD.reduceByKey(_ + _)

    //将聚合的结果进行转换
    val newMapRDD: RDD[(String, (String, Int))] = reduceRDD.map {
      case ((prv, ad), sum) => {
        (prv, (ad, sum))
      }
    }
    //
    val groupRDD = newMapRDD.groupByKey()


    val result = groupRDD.mapValues(
      iter => {
        iter.toList.sortBy(_._2)(Ordering.Int.reverse).take(3)
      }
    )

    result.collect().foreach(println)

    sc.stop()
  }

}
