package com.spark.core.operator.transform

import org.apache.spark.{SparkConf, SparkContext}

object Spark03_RDD_Operator_Transform {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(sparkConf)

    val rdd = sc.makeRDD(List(1, 2, 3, 4, 5),2)

    val mapRDD = rdd.mapPartitionsWithIndex(
      (index,iter) => {
        if (index == 1) List(iter.max).iterator else Nil.iterator
      }
    )


    mapRDD.collect().foreach(println)

    sc.stop()
  }

}
