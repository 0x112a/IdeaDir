package leetcode



object findSubstring {

  import scala.collection.mutable
  def findSubstring(s: String, words: Array[String]) : List[Int] = {
    import scala.collection.mutable.ListBuffer

    val word = mutable.Map[String,Int]()

    words.foreach(
      w =>{
        val i = word.getOrElse(w,0)
        word.updated(w,i+1)
      }
    )

    val wordLen = words(0).size
    val lenWin = words.length * wordLen

    val ans = ListBuffer[Int]()


    for(i <- 0 to (s.length - lenWin)){
      val str = s.substring(i, i + lenWin)
      if (isSubstring(str,wordLen, word,words)){
        ans.append(i)
      }
    }

    ans.toList

  }

  def isSubstring(s: String,wordLen: Int, word: mutable.Map[String,Int],words: Array[String]): Boolean = {
    val sLen = s.length
    val string: mutable.Map[String, Int] = mutable.Map[String, Int]()

//    words.foreach(
//      w =>{
//        val i = word.getOrElse(w,0)
//        word.updated(w,i+1)
//      }
//    )


    for(i <- 0 to ( sLen - wordLen) by(wordLen)){
      val str = s.substring(i,i+wordLen)

      val i1 = string.getOrElse(str, 0)

      string.update(str,i1+1)

    }

    var ans  = false

    words.foreach(k => {
      if (word.getOrElse(k,0) == string.getOrElse(k,0)) ans = true
    })
    ans
  }

}
//
//def findSubstring(s: String, words: Array[String]): List[Int] = {
//  import scala.collection.mutable.ListBuffer
//
//  val lenWin = words.length * words(0).size
//
//  val ans = ListBuffer[Int]()
//
//
//  for(i <- 0 to (s.length - lenWin)){
//  val str = s.substring(i, i + lenWin)
//  if (isSubstring(str,words)){
//  ans.append(i)
//  }
//  }
//
//  ans.toList
//
//  }
//
//  def isSubstring(s: String, words: Array[String]): Boolean = {
//  import scala.collection.mutable
//  val wordLen = words(0).length
//  val sLen = s.length
//  //    val strings: Array[String] = new Array[String](wordLen)
//  val string: mutable.Map[String, Int] = mutable.Map[String, Int]()
//  val word = mutable.Map[String,Int]()
//
//  words.foreach(
//  w =>{
//  val i = word.getOrElse(w,0)
//  word.update(w,i+1)
//  }
//  )
//
//
//  for(i <- 0 to ( sLen - wordLen) by(wordLen)){
//  val str = s.substring(i,i+wordLen)
//
//  val i1 = string.getOrElse(str, 0)
//  string.update(str,i1+1)
//
//
//  }
//
//  var ans  = true
//  words.foreach(k => {
//  if (word.getOrElse(k,0) != string.getOrElse(k,0)) ans = false
//  })
//  ans
//  }
