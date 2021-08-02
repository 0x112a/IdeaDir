package leetcode

class LinkNode(_x: Int, _next: LinkNode,_prev: LinkNode){
  var x = _x
  var next = _next
  var prev = _prev
}

class MyLinkedList() {

  /** Initialize your data structure here. */
  val head: LinkNode = new LinkNode(0,null,null)
  var size: Int = 0



  /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
  def get(index: Int): Int = {
    if (index >= size) -1 else {
      var temp = head
      for (_ <- 0 to index){
        temp= temp.next
      }
      temp.x
    }
  }

  /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
  def addAtHead(`val`: Int) {
    head.next = new LinkNode(`val`,head.next,head)
    size += 1
  }

  /** Append a node of value val to the last element of the linked list. */
  def addAtTail(`val`: Int) {
    var temp: LinkNode = head
    while (temp.next != null) temp=temp.next
    temp.next = new LinkNode(`val`,temp.next,temp)
    size+=1
  }

  /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
  def addAtIndex(index: Int, `val`: Int) {
    if(index < 0) addAtHead(`val`)
    else if (index > size) return
    else if (index == size) addAtTail(`val`)
    else {
      var temp: LinkNode = head
      for (i <- 0 until index) {
        temp = temp.next
      }
      temp.next = new LinkNode(`val`,temp.next,temp)
      size+=1
    }
  }

  /** Delete the index-th node in the linked list, if the index is valid. */
  def deleteAtIndex(index: Int) {
    if(index < size && index >=0){
      var temp = head
      for (_ <- 0 until index){
        temp= temp.next
      }
      temp.next = temp.next.next
      size-=1
    }
  }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * var obj = new MyLinkedList()
 * var param_1 = obj.get(index)
 * obj.addAtHead(`val`)
 * obj.addAtTail(`val`)
 * obj.addAtIndex(index,`val`)
 * obj.deleteAtIndex(index)
 */