package com.spark.gps.countOrderNumberByEveryDay.util

import org.apache.spark.SparkContext

object EnvUtil {

  private val value = new ThreadLocal[SparkContext]

  def put(sc: SparkContext)={
    value.set(sc)
  }

  def get(): SparkContext = {
    value.get()
  }

  def clear()={
    value.remove()
  }
}
