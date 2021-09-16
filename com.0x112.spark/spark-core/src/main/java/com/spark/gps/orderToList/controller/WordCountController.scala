package com.spark.gps.orderToList.controller

import com.spark.gps.orderToList.common.TController
import com.spark.gps.orderToList.service.WordCountService

class WordCountController extends TController {

  private val wordCountService = new WordCountService()

  override def dispatch() ={
    // TODO execution operation
    val array = wordCountService.dataAnalysis()

//    array.foreach(println)
  }



}
