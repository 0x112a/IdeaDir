package com.intoan.learn

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.{SaveMode, SparkSession}

object sql_01 {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("learn spark-sql").setMaster("local[*]")


    val session = SparkSession.builder().config(conf).getOrCreate()

    import session.implicits._

    val metaRDD = session.sparkContext.textFile("datas/part-00000")


    val listMetaRDD: RDD[DayOrderSum] = metaRDD.map(row => {
      val str = row.substring(1, row.length - 1)
      val strings = str.split(",")
      (strings(0),strings(1))
      DayOrderSum(strings(0),strings(1).toInt)
    })


    val ds = listMetaRDD.toDS()

    ds.write.format("jdbc")
      .option("url","jdbc:mysql://localhost:3306/spark_sql")
      .option("user","root")
      .option("password","1q2w3e")
      .option("dbtable","everyday_order_sum")
      .mode(SaveMode.Append)
      .save()




    session.stop()

  }

  case class DayOrderSum(day: String,sum: Int)
}
