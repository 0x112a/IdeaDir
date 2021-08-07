package com.spark.core.operator.transform

import org.apache.spark.{SparkConf, SparkContext}

object Spark16_RDD_Operator_Transform {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(sparkConf)

    //Key-value
    val rdd = sc.makeRDD(List(
      ("a",1),("b",2),("c",2),("a",4),("c",5)
    ))

    val groupByKeyRdd = rdd.groupByKey()

    groupByKeyRdd.collect().foreach(println)

    val groupBy = rdd.groupBy(_._1)

    groupBy.collect().foreach(println)




    sc.stop()
  }

}
