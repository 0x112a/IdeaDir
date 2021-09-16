package com.spark.gps.countOrderNumberByEveryDay.controller

import com.spark.gps.countOrderNumberByEveryDay.common.TController
import com.spark.gps.countOrderNumberByEveryDay.service.CountOrderService

class CountOrderController extends TController{

  private val service = new CountOrderService

  override def dispatch(): Unit = {
    val value = service.dataAnalysis()

  }
}
