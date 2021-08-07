package com.spark.core.operator.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark18_RDD_Operator_Transform {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(sparkConf)

    //Key-value
    val rdd = sc.makeRDD(List(
      ("b",8),("a",9),("a",2),("b",4),("b",5),("a",10)
    ),2)


    val value: RDD[(String, (Int, Int))] = rdd.aggregateByKey((Int.MinValue, 0))(
      (t, v) => {
        (t._1 + v, t._2 + 1)
      },
      (t1, t2) => {
        (t1._1 + t2._1, t1._2 + t2._2)
      }
    )

    value.mapValues{
      case (v,count) => {
      v / count
    }
    }.collect().foreach(println)


    sc.stop()
  }

}
