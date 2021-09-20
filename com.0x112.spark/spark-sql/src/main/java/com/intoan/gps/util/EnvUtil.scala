package com.intoan.gps.util

import org.apache.spark.sql.SparkSession

object EnvUtil {

  private val value = new ThreadLocal[SparkSession]

  def get()={
    value.get()
  }

  def set(spark: SparkSession) ={
    value.set(spark)
  }

  def clear()={
    value.remove()
  }

}
