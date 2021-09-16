package com.spark.gps.countOrderNumberByEveryDay.common

import com.spark.gps.countOrderNumberByEveryDay.util.EnvUtil
import org.apache.spark.{SparkConf, SparkContext}


trait TApplication {

  def start(appName: String = "New Application")(op: => Unit)={
    //创建配置文件
//    val sparkConf = new SparkConf().setAppName(appName).setMaster("local[*]")
    val sparkConf = new SparkConf().setAppName(appName)

    //创建Spark环境
    val sc = new SparkContext(sparkConf)

    EnvUtil.put(sc)

    try {
      op
    }catch{
      case ex => println(ex)
    }

    sc.stop()
    EnvUtil.clear()

  }

}
