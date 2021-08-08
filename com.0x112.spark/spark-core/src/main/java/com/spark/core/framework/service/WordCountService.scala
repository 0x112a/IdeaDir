package com.spark.core.framework.service

import com.spark.core.framework.common.TService
import com.spark.core.framework.dao.WordCountDao
import org.apache.spark.rdd.RDD

class WordCountService extends TService{

  private val wordCountDao = new WordCountDao()

  def dataAnalysis() = {

    // 1. 读取文件，按行
    val lines = wordCountDao.readFile("datas/2.txt")

    // 2. 分割数据
    val words: RDD[String] = lines.flatMap(_.split(" "))

    // 3. 分组，便于统计
    val wordGroup: RDD[(String,Iterable[String])] = words.groupBy(word => word)

    // 4.转换，统计
    val wordToCount = wordGroup.map{
      case  (word,list) => {
        (word, list.size)
      }
    }

    // 5.打印结果

    val array: Array[(String,Int)] = wordToCount.collect()
    array
  }
}
