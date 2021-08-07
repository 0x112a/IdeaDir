package com.spark.core.operator.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark12_RDD_Operator_Transform1 {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(sparkConf)

    val rdd: RDD[(String, Int)] = sc.makeRDD(List(("1", 1), ("11", 2), ("2", 3)), 2)


    val newRdd = rdd.sortBy(num => num._1.toInt )


    newRdd.saveAsTextFile("output")

    sc.stop()
  }

}
