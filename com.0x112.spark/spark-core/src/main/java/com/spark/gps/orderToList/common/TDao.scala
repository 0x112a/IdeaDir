package com.spark.gps.orderToList.common

import com.spark.gps.orderToList.util.EnvUtil

trait TDao {

  def readFile(path: String) = {

    val sc = EnvUtil.take()
    sc.textFile(path)
  }

}
