package leetcode

import scala.collection.mutable

class MinStack() {

  /** initialize your data structure here. */
  private val x = new mutable.Stack[Int]()
  private val xMin = new mutable.Stack[Int]()
  xMin.push(Int.MaxValue)

  def push(`val`: Int) {
    x.push(`val`)
    if (`val` < xMin.top) xMin.push(`val`) else xMin.push(xMin.top)
  }

  def pop(): Unit = {
      x.pop()
      xMin.pop()
  }

  def top(): Int = {
      x.top
  }

  def getMin(): Int = {
    xMin.top
  }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = new MinStack()
 * obj.push(`val`)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */