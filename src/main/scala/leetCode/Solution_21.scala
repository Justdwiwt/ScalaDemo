package leetCode

class ListNode(var _x: Int = 0) {
  var next: ListNode = _
  var x: Int = _x
}

object Solution_21 {
  def mergeTwoLists(l1: ListNode, l2: ListNode): ListNode = {
    var l: ListNode = new ListNode()
    var tmp: ListNode = new ListNode()
    var ans: ListNode = new ListNode()
    var L1: ListNode = l1
    var L2: ListNode = l2
    if (L1 == null) return L2
    if (L2 == null) return L1
    if (L1.x > L2.x) {
      l = L2
      L2 = L1
      L1 = l
    }
    ans = L1
    while (L2 != null) {
      if (L1 == null) return ans
      if (L1.next == null || L2.x < L1.next.x) {
        l = L1.next
        tmp = L2.next
        L1.next = L2
        L2.next = l
        L1 = L2
        L2 = tmp
      } else L1 = L1.next
    }
    ans
  }
}
