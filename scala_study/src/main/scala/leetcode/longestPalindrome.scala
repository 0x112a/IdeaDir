package leetcode

object longestPalindrome {
  def longestPalindrome(s:String):String ={
    val n = s.length
    val dp = new Array[Array[Int]](n)
    for(i <- 0 until n){
      dp(i) = new Array[Int](n)
    }
    var ans: String = new String

    for (i <- 0 until n){
      for (j <- 0 until n if j+i<n){
        val t = i + j
        if (i == 0) {
          dp(j)(t) = 1
        }else if( i == 1) {
          if (s.charAt(j)==s.charAt(t)){
            dp(j)(t) = 1
          }
        }else{
          if(s.charAt(j)==s.charAt(t)){
            dp(j)(t) = dp(j+1)(t-1)
          }
        }

        if(dp(j)(t) > 0 && i+1 > ans.length){
          ans = s.substring(j,t+1)
        }

      }
    }
    ans
  }

}
