package com.spark.core.operator.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark11_RDD_Operator_Transform {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(sparkConf)

    val rdd: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 0),3)


    //分区扩大,必须shuffle
//    val newRdd = rdd.coalesce(3,true)
    //通常使用repartition，底层使用coalesce
val newRdd = rdd.repartition(3)

    newRdd.saveAsTextFile("output")


    sc.stop()
  }

}
