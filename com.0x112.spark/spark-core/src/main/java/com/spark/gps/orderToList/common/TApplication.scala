package com.spark.gps.orderToList.common

import com.spark.gps.orderToList.util.EnvUtil
import org.apache.spark.{SparkConf, SparkContext}

trait TApplication {

  def start(appName: String = "Application")(op: => Unit) = {

    val sparkConf = new SparkConf().setAppName(appName)

    val sc = new SparkContext(sparkConf)

    EnvUtil.put(sc)

    try{
      op
    }catch {
      case ex => println(ex.getMessage)
    }

    sc.stop()
    EnvUtil.clear()
  }

}
