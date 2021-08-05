package leetcode

object findTheWinner {
  def findTheWinner(n: Int, k: Int): Int = {
    if (n == 1) n else (findTheWinner(n-1,k) + k -1) % n +1
  }

}
