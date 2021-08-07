package com.spark.core.operator.transform

import org.apache.spark.{SparkConf, SparkContext}

object Spark01_RDD_Operator_Transform_parallelism {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(sparkConf)

    val rdd = sc.makeRDD(List(1, 2, 3, 4, 5),2)

    val mapRDD = rdd.map(
      line => {
        println(">>>>>>>" + line)
        line
      }
    )

    val mapRDD1 = mapRDD.map(
      num => {
        println("<<<<<<" + num)
        num
      }
    )

//    mapRDD.collect().foreach(println)
    mapRDD1.collect()

    sc.stop()
  }

}
