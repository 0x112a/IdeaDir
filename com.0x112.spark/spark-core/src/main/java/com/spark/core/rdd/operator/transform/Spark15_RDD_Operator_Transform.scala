package com.spark.core.operator.transform

import org.apache.spark.{HashPartitioner, SparkConf, SparkContext}

object Spark15_RDD_Operator_Transform {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(sparkConf)

    //Key-value
    val rdd = sc.makeRDD(List(
      ("a",1),("b",2),("c",3),("a",4),("c",5)
    ))

    val reduceRdd = rdd.reduceByKey((x: Int, y: Int) => x + y)

    reduceRdd.collect().foreach(println)




    sc.stop()
  }

}
