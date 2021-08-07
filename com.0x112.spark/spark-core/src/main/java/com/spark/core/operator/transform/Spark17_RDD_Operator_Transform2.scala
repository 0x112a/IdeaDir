package com.spark.core.operator.transform

import org.apache.spark.{SparkConf, SparkContext}

object Spark17_RDD_Operator_Transform2 {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(sparkConf)

    //Key-value
    val rdd = sc.makeRDD(List(
      ("b",8),("a",9),("a",2),("b",4),("b",5),("a",10)
    ),2)


    //如果分区内和分区间计算规则相同，spark提供了简化的规则
    rdd.foldByKey(Int.MinValue)(_+_).collect().foreach(println)

    sc.stop()
  }

}
