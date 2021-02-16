package leetCode

object Solution_237 {
  def deleteNode(node: ListNode): Unit = {
    node.x = node.next.x
    node.next = node.next.next
  }
}
