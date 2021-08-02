package leetcode

class ListNode(_x: Int, _next: ListNode) {
  var next: ListNode= _next
  var x: Int = _x

}

object Solution{
  def getIntersectionNode(headA:ListNode,headB:ListNode):ListNode={
    if (headA == null || headB == null) return null
    var pa = headA
    var pb = headB
    while(pa != pb){
      if (pa ==null) pa = headB else pa=pa.next
      if (pb ==null) pb = headA else pb=pb.next
    }
   pb
  }
}
