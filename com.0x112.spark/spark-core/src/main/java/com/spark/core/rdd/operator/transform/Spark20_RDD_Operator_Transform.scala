package com.spark.core.operator.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark20_RDD_Operator_Transform {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(sparkConf)

    //Key-value
    val rdd = sc.makeRDD(List(
      ("b",8),("a",9),("a",2),("b",4),("b",5),("a",10)
    ),2)
    /*

     */

    rdd.reduceByKey(_+_)
    rdd.aggregateByKey(0)(_+_,_+_)
    rdd.foldByKey(0)(_+_)
    rdd.combineByKey(v => v,(x: Int,y) => x + y ,(x: Int,y: Int) => x + y)

    sc.stop()
  }

}
