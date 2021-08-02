package leetcode

class ListNode(_x: Int, _next: ListNode) {
  var x = _x
  var next = _next

}

object Solution{
  def swapPairs(head: ListNode): ListNode= {
    if(head == null || head.next == null) return head
    //设置一个哑节点
    val dumpHead = new ListNode(0,head)

    var temp = dumpHead
    var node1 = temp
    var node2 = temp

    while (temp.next != null && temp.next.next != null){
      //移动指针
      node1 = temp.next
      node2 = node1.next
      //交换节点
      temp.next = node2
      node1.next = node2.next
      node2.next = node1

      //移动指针
      temp = node1
    }

    dumpHead.next
  }
}