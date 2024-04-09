package leetCode._100

object Solution_61 {
  def rotateRight(head: ListNode, k: Int): ListNode = {
    if (head == null || k == 0) return head
    val (lastNode: ListNode, index: Int) = getLastNodeWithIndex(head)
    lastNode.next = head
    val node = moveRight(head, index - (k % index) - 1)
    val res = node.next
    node.next = null
    res
  }

  @scala.annotation.tailrec
  private def getLastNodeWithIndex(head: ListNode, index: Int = 0): (ListNode, Int) = head.next match {
    case null => (head, index + 1)
    case others => getLastNodeWithIndex(others, index + 1)
  }

  @scala.annotation.tailrec
  private def moveRight(head: ListNode, i: Int): ListNode = i match {
    case 0 => head
    case _ => moveRight(head.next, i - 1)
  }
}
