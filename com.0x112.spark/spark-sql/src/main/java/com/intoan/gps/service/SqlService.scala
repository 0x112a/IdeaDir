package com.intoan.gps.service

import com.intoan.gps.common.TService
import com.intoan.gps.dao.SqlDao

class SqlService extends TService{

  private val dao = new SqlDao

  override def dataAnalysis(): Any = {
    val filePath = "datas/part-00000"
    val value = dao.readFile(filePath)
    value

  }
}
