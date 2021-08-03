package leetcode

class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

object Solution {

  def reverseKGroup(head: ListNode, k: Int): ListNode = {
    val dumpHead = new ListNode(0,head)
    var cur = dumpHead
    def checkLeng( h: ListNode, l: Int):Boolean = {
      var p = h
      for (i <- 0 until l) if(p == null) return false else p = p.next
      true
    }
    while (checkLeng(cur.next,k)) {
      val tail = cur.next
      val h = new ListNode()
      var p1 = tail
      for (_ <- 0 until k){
        //储存当前节点的后继
        val p2=p1.next

        //头插法逆置链表
        //当前结点指向头节点的后继
        p1.next = h.next
        //头结点的后继指向当前结点
        h.next = p1
        //移动当前结点
        p1 = p2
        //存储反转后的最后一个结点的后继
        tail.next = p2
      }
      cur.next = h.next
      cur = tail
    }

    dumpHead.next
  }
}
