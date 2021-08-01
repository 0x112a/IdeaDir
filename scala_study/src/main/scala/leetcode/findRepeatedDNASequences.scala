package leetcode



object findRepeatedDNASequences {

    def findRepeatedDnaSequences(s: String): List[String] = {
      val win: Int =10
      val n = s.length
      val seen = scala.collection.mutable.HashSet[String]()
      val output = scala.collection.mutable.HashSet[String]()


      for (i <- 0 until( n - win + 1)){
        val str = s.substring(i, i + win)
        if(seen.contains(str)) output.add(str)
        seen.add(str)


      }
      output.toList
    }
}
