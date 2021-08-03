package leetcode

class ListNode(_x: Int, _next: ListNode) {
  var x = _x
  var next = _next
}

object Solution{
  def reorderList(head: ListNode): Unit= {
    var p = head
    var len: Int  = 0
    while (p != null){
      len += 1
      p = p.next
    }
    p=head
    val l1 = new ListNode(0,head)
    val l2 = new ListNode(0,null)

    for (_ <- 1 until ( len / 2 + len % 2)){
      p=p.next
    }
    //截取前半段列表
    val tail = p
    p=p.next
    tail.next = null

    // 反转后半段链表
    while (p != null) {
      //头插法逆置链表
      val pPost = p.next
      p.next = l2.next
      l2.next = p
      p= pPost
    }

    //合并两个链表

    var p1 = l1.next
    p = l2.next
    while (p != null && p1 != null){
      val p1Post = p1.next
      val pPost = p.next
      p1.next = p
      p.next = p1Post

      p1 = p1Post
      p = pPost
    }

  }

}
