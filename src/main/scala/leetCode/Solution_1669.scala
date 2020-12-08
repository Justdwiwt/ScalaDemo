package leetCode

object Solution_1669 {
  def mergeInBetween(list1: ListNode, a: Int, b: Int, list2: ListNode): ListNode = {
    var node = list1
    (0 until a - 1).foreach(_ => node = node.next)
    var n1 = node.next
    (0 until b - a + 1).foreach(_ => n1 = n1.next)
    node.next = list2
    while (node.next != null) node = node.next
    node.next = n1
    list1
  }
}
