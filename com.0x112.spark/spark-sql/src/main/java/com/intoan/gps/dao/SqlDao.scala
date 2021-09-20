package com.intoan.gps.dao

import com.intoan.gps.common.TDao
import com.intoan.gps.util.EnvUtil

class SqlDao extends TDao{

  override def readFile(path: String): Any = {

    val session = EnvUtil.get()

    val value = session.sparkContext.textFile(path)

    value

  }

}
