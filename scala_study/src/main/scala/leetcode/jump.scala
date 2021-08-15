package leetcode

/*
class Solution {
    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
 */

object jump {
  def jump(nums: Array[Int]): Int = {
    val n = nums.length
    var maxPosition = 0
    var end = 0
    var step = 0

    for(i <- 0 until n-1){
      maxPosition = math.max(maxPosition,i+nums(i))

      if (i == end) {
        end = maxPosition
        step+=1
      }
    }
    step
  }

}
