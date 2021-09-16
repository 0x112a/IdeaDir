package com.spark.gps.countOrderNumberByEveryDay.application

import com.spark.gps.countOrderNumberByEveryDay.common.TApplication
import com.spark.gps.countOrderNumberByEveryDay.controller.CountOrderController

object OrderCountByEveryDayApplication extends TApplication{

  def main(args: Array[String]): Unit = {
    start("Count Order Number By Every Day"){

      val controller = new CountOrderController

      controller.dispatch()
    }
  }
}
