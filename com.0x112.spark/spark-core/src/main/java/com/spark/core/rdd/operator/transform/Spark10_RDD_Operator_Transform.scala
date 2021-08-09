package com.spark.core.operator.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark10_RDD_Operator_Transform {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(sparkConf)

    val rdd: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 0),3)


    //分区缩减
    //maybe 数据不均衡，导致数据倾斜
    //想让数据均衡，可以进行shuffle处理，打乱重组
    val newRdd = rdd.coalesce(2,true)

    newRdd.saveAsTextFile("output")


    sc.stop()
  }

}
