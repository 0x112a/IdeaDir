package leetcode

object addTowNumbers {

  def addTowNumbers(l1: ListNode, l2: ListNode):ListNode = {
    var l = l1
    var l3 = l2
    if (l == null && l3 == null) return null

    var add: Int = 0
    val ans: ListNode = new ListNode(0,null)
    var p:ListNode = ans
    l

    while(l != null || l3 != null || add != 0  ){
      var sum: Int = 0
      if (l != null) {
        sum += l.x
        l=l.next
      }
      if(l3 != null){
        sum += l3.x
        l3 = l3.next
      }
      sum += add
      p.next = new ListNode(sum%10,null)
      p = p.next
      add = sum /10
    }
    ans.next
  }

}

class ListNode(_x: Int, _next: ListNode) {
  var next: ListNode= _next
  var x: Int = _x

}