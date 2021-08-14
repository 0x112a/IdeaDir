package leetcode

import scala.collection.mutable
/*

class Solution {
  public int[] searchRange(int[] nums, int target) {
    int leftIdx = binarySearch(nums, target, true);
    int rightIdx = binarySearch(nums, target, false) - 1;
    if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
      return new int[]{leftIdx, rightIdx};
    }
    return new int[]{-1, -1};
  }

  public int binarySearch(int[] nums, int target, boolean lower) {
    int left = 0, right = nums.length - 1, ans = nums.length;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (nums[mid] > target || (lower && nums[mid] >= target)) {
        right = mid - 1;
        ans = mid;
      } else {
        left = mid + 1;
      }
    }
    return ans;
  }
}
 */
object searchRange {

  def searchRange(nums: Array[Int], target: Int): Array[Int] = {
    val ans = new Array[Int](2)

    val leftid = binarySearch(nums,target,true)
    val rightid = binarySearch(nums,target,false) - 1

    if (leftid <= rightid && rightid < nums.length && nums(leftid) == target && nums(rightid) == target) {
      ans(0) = leftid
      ans(1) = rightid
      ans
    }else{
      ans(0) = -1
      ans(1) = -1
      ans
    }

  }

  def binarySearch(nums: Array[Int],target: Int,lower: Boolean): Int={
    val n = nums.length
    var left = 0
    var right = n-1
    // why need ans equal n?
    var ans: Int = n

    while (left <= right){
      val mid = (left+right)/2

      if (nums(mid) > target || (lower && nums(mid)>= target)) {
        right = mid - 1
        ans = mid
      }else{
        left = mid + 1
      }
    }
    ans
  }

}

/*
object Solution {
    def searchRange(nums: Array[Int], target: Int): Array[Int] = {

        var left=0
        var right=nums.size-1

        while(left<=right){
            var mid=(left+right)/2
            if(nums(mid)==target)
            right=mid-1
            else if(nums(mid)<target)
            left=mid+1
            else
            right=mid-1
        }

        var l=0
        var r=nums.size-1

        while(l<=r){
            var mid=(l+r)/2
            if(nums(mid)==target)
            l=mid+1
            else if(nums(mid)<target)
            l=mid+1
            else
            r=mid-1
        }

        if(left>r) Array(-1,-1) else  Array(left,r)


    }
}
 */
