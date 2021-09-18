package com.spark.gps.countOrderNumberByEveryDay.service

import com.spark.gps.countOrderNumberByEveryDay.common.TService
import com.spark.gps.countOrderNumberByEveryDay.dao.CountOrderDao
import org.apache.spark.rdd.RDD

class CountOrderService extends TService{

  private val dao = new CountOrderDao

  def process(input: String,ouput: String) ={

    val fileRDD = dao.readFile(input)

    val value = fileRDD.map(data => {
      data.split(",")(1)
    })

    val value1 = value.distinct()

    val value2: RDD[(String, Int)] = value1.map(_ =>{
      val strings = input.split("/")
      (strings(strings.length-1), 1)
    })


    val value3 = value2.reduceByKey(_ + _)

    val tuples: Array[(String, Int)] = value3.collect()

    tuples.head
  }

  override def dataAnalysis(): Any = {

    // 运行命令
    // ./bin/spark-submit --class com.spark.gps.countOrderNumberByEveryDay.application.OrderCountByEveryDayApplication --master yarn --deploy-mode cluster ~/everyCount.jar

    val list = new Array[(String,Int)](30)
    var outPath = "hdfs://master:8020/everyOut"

    for (i <- 101 to 130){
      var fileName = "hdfs://master:8020/gis/gps_20161"

      fileName += i

      list(i-101) = process(fileName,outPath)
    }

    val value = dao.makeRDDByList(list)
    value.repartition(1).sortBy(_._1).saveAsTextFile(outPath)

  }
}
