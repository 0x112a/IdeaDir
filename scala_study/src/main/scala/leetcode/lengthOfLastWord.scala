package leetcode

object Solution {
  def lengthOfLastWord(s: String): Int = {
    val strings: Array[String] = s.split(" ")
    strings.last.length

  }
}
