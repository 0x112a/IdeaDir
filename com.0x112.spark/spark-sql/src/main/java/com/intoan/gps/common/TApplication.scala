package com.intoan.gps.common

import com.intoan.gps.util.EnvUtil
import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}

trait TApplication {

  def start(name: String, cluset: String)(op: => Unit): Unit ={

    val conf = new SparkConf().setAppName(name).setMaster(cluset)

    val session = SparkSession.builder().config(conf).getOrCreate()

    EnvUtil.set(session)

    try {
      op
    }catch {
      case ex => println(ex.getMessage)
    }

    session.stop()

    EnvUtil.clear()
  }


}
