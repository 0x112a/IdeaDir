package com.spark.core.framework.controller

import com.spark.core.framework.common.TController
import com.spark.core.framework.service.WordCountService
import org.apache.spark.rdd.RDD

class WordCountController extends TController {

  private val wordCountService = new WordCountService()

  override def dispatch() ={
    // TODO execution operation
    val array = wordCountService.dataAnalysis()

    array.foreach(println)
  }

}
