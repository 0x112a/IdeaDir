package leetcode

class TreeNode(var value: Int = 0,var left: TreeNode = null, var right: TreeNode = null){}

object isSameTree {
  def isSameTree(p: TreeNode,q: TreeNode): Boolean = {
    if (p == q == null) return true
    else if(p == null && q != null || p != null && q == null) return false
    var p1 = p
    var q1 = q
    if(p1.value == q1.value) {
      val ans1 = isSameTree(p1.left,q1.left)
      val ans2 = isSameTree(p1.right,q1.right)
      ans1 == ans2 && ans1 == true
    }else{
      false
    }
  }
}
