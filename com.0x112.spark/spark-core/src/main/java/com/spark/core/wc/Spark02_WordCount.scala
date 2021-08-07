package com.spark.core.wc

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark02_WordCount {

  def main(args: Array[String]): Unit = {

    //Application
    //Spark framework
    // TODO create connect spark
    // JDBC : Connection
    val sparConf = new SparkConf().setMaster("local").setAppName("WordCount")
    val sc = new SparkContext(sparConf)


    // TODO execution operation
    // 1. 读取文件，按行
    val lines: RDD[String] = sc.textFile("datas")

    // 2. 分割数据
    val words: RDD[String] = lines.flatMap(_.split(" "))

    val wordToOne = words.map(
      word => (word, 1)
    )

    // 3. 分组，便于统计
    val wordGroup: RDD[(String,Iterable[(String,Int)])] = wordToOne.groupBy(
      t => t._1
    )

    // 4.转换，统计
    val wordToCount = wordGroup.map{
      case  (word,list) => {
        list.reduce(
          (t1,t2) => {
            (t1._1,t1._2+t2._2)
          }
        )
      }
    }

    // 5.打印结果

    val array: Array[(String,Int)] = wordToCount.collect()
    array.foreach(println)

    // TODO close connect
    sc.stop()


  }

}
