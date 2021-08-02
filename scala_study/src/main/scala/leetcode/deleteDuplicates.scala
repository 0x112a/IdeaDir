package leetcode

class ListNode(_x: Int, _next: ListNode) {
  var x = _x
  var next = _next

}

object Solution{
  def deleteDuplicates(head: ListNode):ListNode = {
    if (head == null) return head

    var ans: ListNode = new ListNode(0,head)
    var start = ans

    while (start.next != null && start.next.next != null){
      if (start.next.x == start.next.next.x) {
        val X  = start.next.x
        while(start.next != null && start.next.x == X ) start.next = start.next.next
      }else{
        start = start.next
      }
    }
    ans.next
  }
}