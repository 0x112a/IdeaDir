package leetcode

object SingleNumber {

  def singleNumber(nums: Array[Int]): Int = {
    val length = nums.length

    var ans = nums(0)
    for (i <- 1 until length){
      ans |= nums(i)
    }
    ans
  }

}
