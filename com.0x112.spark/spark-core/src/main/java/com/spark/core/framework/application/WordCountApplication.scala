package com.spark.core.framework.application

import com.spark.core.framework.common.TApplication
import com.spark.core.framework.controller.WordCountController
import org.apache.spark.{SparkConf, SparkContext}

object WordCountApplication extends App with TApplication{

  //start Application
  start(){

    val wordCountController = new WordCountController()

    wordCountController.dispatch()
  }



}
