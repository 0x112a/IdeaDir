package com.spark.core.operator.transform

import org.apache.spark.{SparkConf, SparkContext}

object Spark17_RDD_Operator_Transform1 {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(sparkConf)

    //Key-value
    val rdd = sc.makeRDD(List(
      ("b",8),("a",9),("a",2),("b",4),("b",5),("a",10)
    ),2)

    //存在函数的柯里化
    // 第一个为初始值
    // 第二个值有两个参数
    //第一个参数分区内计算规则
    //第二个参数分区间计算规则
    val aggregateRDD = rdd.aggregateByKey(Int.MinValue)(math.max(_, _), _ + _)

    aggregateRDD.collect().foreach(println)


    sc.stop()
  }

}
