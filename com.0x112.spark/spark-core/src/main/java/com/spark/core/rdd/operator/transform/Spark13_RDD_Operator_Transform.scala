package com.spark.core.operator.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark13_RDD_Operator_Transform {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(sparkConf)

    val rdd1 = sc.makeRDD(List(1, 2, 3, 4))
    val rdd2 = sc.makeRDD(List(3, 4, 5, 6))

    //交集
    val rdd3 = rdd1.intersection(rdd2)
    println(rdd3.collect().mkString(","))

    //并集
    val rdd4 = rdd1.union(rdd2)
   println(rdd4.collect().mkString("."))
    //差集
    val rdd5 = rdd1.subtract(rdd2)
    println(rdd5.collect().mkString("/"))

    //拉链（zip）
    val rdd6 = rdd1.zip(rdd2)
    println(rdd6.collect().mkString(";"))

    sc.stop()
  }

}
