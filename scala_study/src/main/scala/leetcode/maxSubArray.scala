package leetcode

object maxSubArray {
  //分治法 + 递归
  def maxSubArray(nums: Array[Int]): Int = {
    findMaxSubArray(nums,0,nums.length-1)
  }

  //
  def findMaxSubArray(nums: Array[Int],l: Int, r: Int): Int= {
    if (l == r ) return nums(l)

    val mid = (l+r)/2
    val leftSum = findMaxSubArray(nums, l, mid)
    val rightSum = findMaxSubArray(nums, mid + 1, r)
    val corseSum = corseMidMaxSubArray(nums, l, mid, r)

    math.max(math.max(leftSum,rightSum),corseSum)
  }

  //求跨越中点的子数组最大和
  def corseMidMaxSubArray(nums: Array[Int],low: Int, mid: Int, high: Int): Int= {

    var leftSum = Int.MinValue
    var sum = 0

    for (i <- mid to low by -1){
      sum+=nums(i)
      if (sum > leftSum){
        leftSum = sum
      }
    }

    var rightSum = Int.MinValue
    sum = 0

    for(i <- mid+1 to high){
      sum+=nums(i)

      if (sum > rightSum) {
        rightSum = sum
      }
    }

    rightSum+leftSum
  }

}
