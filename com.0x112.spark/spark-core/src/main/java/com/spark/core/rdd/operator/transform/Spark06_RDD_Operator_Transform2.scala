package com.spark.core.operator.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

import java.text.SimpleDateFormat

object Spark06_RDD_Operator_Transform2 {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(sparkConf)

    val rdd = sc.textFile("datas/wwwlogs/blog.0x112.com-access_log")

//    val mapRDD: RDD[Array[String]] = rdd.map(_.split(" "))

//    val timeRdd: RDD[(String, Iterable[Array[String]])] = mapRDD.groupBy(arr => {
//      arr(3)
//    })

    val mapRdd = rdd.map(line => {
      val datas = line.split(" ")
      val time = datas(3)

      val sdf = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss")
      val date = sdf.parse(time.substring(1))
      val sdf1 = new SimpleDateFormat("HH")
      val hour = sdf1.format(date)

      (hour, 1)
    })

    val groupByHour = mapRdd.groupBy(_._1)

    val timesRdd = groupByHour.map(_ match {
      case (hour, iter) => {
        (hour, iter.size)
      }
    }
    )




    timesRdd.saveAsTextFile("output")



    sc.stop()
  }

}
