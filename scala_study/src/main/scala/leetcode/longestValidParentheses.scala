package leetcode


//class Solution {
//  public int longestValidParentheses(String s) {
//    int maxans = 0;
//    int[] dp = new int[s.length()];
//    for (int i = 1; i < s.length(); i++) {
//      if (s.charAt(i) == ')') {
//        if (s.charAt(i - 1) == '(') {
//          dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
//        } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
//          dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
//        }
//        maxans = Math.max(maxans, dp[i]);
//      }
//    }
//    return maxans;
//  }
//}

object longestValidParentheses {
  def longestValidParentheses(s: String): Int = {
    var ans: Int = 0

    val n = s.length

    val dp = new Array[Int](n)

    for(i <- 1 until n){
      if (s.charAt(i) == ')' ) {
        if (s.charAt(i-1) == '(') {
          dp(i) = if (i>=2) dp(i-2) + 2 else 0 + 2
        }else if(i - dp(i-1) > 0 && s.charAt(i- dp(i-1) - 1) == '(' ) {
          dp(i) = dp(i-1) + {if(i-dp(i-1) >= 2) dp(i -dp(i-1) -2) else 0} +2
        }
        ans = math.max(ans,dp(i))
      }
    }

    ans
  }
}
