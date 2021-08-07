package com.spark.core.operator.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark12_RDD_Operator_Transform {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(sparkConf)

    val rdd: RDD[Int] = sc.makeRDD(List( 2, 3, 4, 5, 6,1, 7, 8, 9, 0),3)


    val newRdd = rdd.sortBy(number => number)


    newRdd.saveAsTextFile("output")

    sc.stop()
  }

}
