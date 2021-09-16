package com.spark.gps.countOrderNumberByEveryDay.common

import com.spark.gps.countOrderNumberByEveryDay.util.EnvUtil

trait TDao {

  def readFile(fileName: String)={
    val context = EnvUtil.get()

    context.wholeTextFiles(fileName)

//    context.textFile(fileName)
  }

}
