package leetcode

import scala.collection.mutable

object majorityElement {

  def majorityElement(nums: Array[Int]): Int = {
    val hashMap: mutable.Map[Int, Int] = new mutable.HashMap[Int, Int]
    val target = nums.length/2

    nums.foreach(
      num => {
        var data = hashMap.getOrElse(num,0)
        data += 1
        hashMap.update(num,data)
        if (data > target) return num
      }
    )

    -1
  }
}
