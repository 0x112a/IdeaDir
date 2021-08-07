package com.spark.core.operator.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark21_RDD_Operator_Transform {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(sparkConf)

    //Key-value
    val rdd1 = sc.makeRDD(List(
      ("a",9),("b",2),("c",4)
    ))

    val rdd2 = sc.makeRDD(
      List(("a", 2), ("b", 5), ("c", 10))
    )

    val joinRdd: RDD[(String, (Int, Int))] = rdd1.join(rdd2)

    // join: 两个不同数据源的数据，相同的key的value会链接在一起，形成元组
    // 如果两个数据源中的key没有匹配上，那么数据不会出现在结果中
    // 如果两个数据源中key中有多个相同的，会依次匹配，
    //  可能会出现笛卡尔乘积的情况，数据量会成倍增加。所以能不使用join就尽量不使用join
    joinRdd.collect().foreach(println)

    sc.stop()
  }

}
