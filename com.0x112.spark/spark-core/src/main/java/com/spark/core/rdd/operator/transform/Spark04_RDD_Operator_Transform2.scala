package com.spark.core.operator.transform

import org.apache.spark.{SparkConf, SparkContext}

object Spark04_RDD_Operator_Transform2 {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(sparkConf)

    val rdd = sc.makeRDD(List(List(1, 2, 3, 4, 5),10,List(9,8,7,6,0)))

    val flatMapRdd = rdd.flatMap(
      data => {
        data match {
          case l: List[Int] => l
          case d => List(d)
        }
      }
    )


    flatMapRdd.collect().foreach(println)

    sc.stop()
  }

}
