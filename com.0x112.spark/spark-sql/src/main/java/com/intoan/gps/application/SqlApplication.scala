package com.intoan.gps.application

import com.intoan.gps.common.TApplication
import com.intoan.gps.controller.SqlController

class SqlApplication extends App with TApplication{

  start("sql learn-01","local[*]"){

    val sqlcontroller = new SqlController()
    sqlcontroller.dispatch()

  }

}
