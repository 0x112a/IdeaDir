package com.spark.gps.orderToList.application

import com.spark.gps.orderToList.common.TApplication
import com.spark.gps.orderToList.controller.WordCountController

object WordCountApplication extends TApplication{

  def main(args: Array[String]): Unit = {
    start("Count order to Json"){

      val wordCountController = new WordCountController()

      wordCountController.dispatch()
    }
  }

}
