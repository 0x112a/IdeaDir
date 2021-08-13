package leetcode

object nextPermutation {
  def nextPermutation(nums: Array[Int]): Unit = {
    var n = nums.length

    //    if ( n == 1 || n == 0) return
    var minLeft: Int = n - 2

    while (minLeft >= 0 && nums(minLeft) > nums(minLeft + 1)) {
      minLeft -= 1
    }

    if (minLeft >= 0) {

      var maxRight: Int = n - 1
      while (maxRight >= 0 && nums(maxRight) <= nums(minLeft)) {
        maxRight -= 1
      }
      //      if (maxRight >= 0) swap(minLeft,maxRight,nums)
      swap(minLeft, maxRight, nums)
    }

    reverse(minLeft + 1, nums)

    //      n -=1
    //      minLeft+=1
    //      while (minLeft < n){
    //        swap(minLeft,n,nums)
    //        minLeft+=1
    //        n-=1
    //      }
  }

  def swap(a: Int, b: Int, nums: Array[Int]): Unit = {
    //    nums(a) = nums(a) + nums(b)
    //    nums(b) = nums(a) - nums(b)
    //    nums(a) = nums(a) - nums(b)
    val temp = nums(a)
    nums(a) = nums(b)
    nums(b) = temp
  }

  def reverse(s: Int, nums: Array[Int]) = {
    var end = nums.length - 1
    var start = s

    while (start < end) {
      swap(start, end, nums)
      start -= 1
      end -= 1
    }
  }

}
