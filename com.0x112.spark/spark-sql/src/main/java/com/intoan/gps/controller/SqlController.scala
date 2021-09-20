package com.intoan.gps.controller

import com.intoan.gps.common.TController
import com.intoan.gps.service.SqlService

class SqlController extends TController{

  private val service = new SqlService

  override def dispatch(): Unit = {

    val value = service.dataAnalysis()

  }
}
