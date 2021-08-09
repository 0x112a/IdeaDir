package com.spark.core.operator.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark22_RDD_Operator_Transform {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(sparkConf)

    //Key-value
    val rdd1 = sc.makeRDD(List(
      ("a",9),("b",2),("c",4)
    ))

    val rdd2 = sc.makeRDD(
      List(("a", 2), ("b", 5)//, ("c", 10))
     ))

    val leftJoinRDD = rdd1.leftOuterJoin(rdd2)
    val rightJoinRDD = rdd2.leftOuterJoin(rdd1)

    leftJoinRDD.collect().foreach(println)
    rightJoinRDD.collect().foreach(println)


    sc.stop()
  }

}
