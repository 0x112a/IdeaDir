package leetcode

class ListNode(_x: Int, _next: ListNode) {
  var x = _x
  var next = _next

}

object Solution{
  def detectCycle(head: ListNode):ListNode = {
    var slow = head
    var fast = slow
    while (fast != null){
      slow=slow.next
      if (fast.next == null) return null
      fast = fast.next.next

      if (fast == slow){
        var cur = head
        while (cur != slow){
          cur =cur.next
          slow = slow.next
        }
        return cur
      }
    }
    null
  }
}
