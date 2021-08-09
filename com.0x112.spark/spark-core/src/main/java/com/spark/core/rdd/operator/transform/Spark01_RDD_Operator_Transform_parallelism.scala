package com.spark.core.rdd.operator.transform

import org.apache.spark.{SparkConf, SparkContext}

object Spark01_RDD_Operator_Transform_parallelism {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(sparkConf)

    val rdd = sc.makeRDD(List(1, 2, 3, 4, 5),1)

//    rdd.saveAsTextFile("output")

    //分区内的执行是一个一个执行的 串行
    //只有前面一个数据的全部逻辑执行完毕后，才会执行下一个数据
    //分区间是并行执行的

    //试着调整 numSlices 的数值观察输出
    val mapRDD = rdd.map(
      line => {
        println(">>>>>>>" + line)
        line
      }
    )

    val mapRDD1 = mapRDD.map(
      num => {
        println("<<<<<<" + num)
        num
      }
    )

//    mapRDD.collect().foreach(println)
    mapRDD1.collect()

    sc.stop()
  }

}
