package leetCode

object Solution_109 {
  def sortedListToBST(head: ListNode): TreeNode = head match {
    case null => null
    case _ => func(head, null)
  }

  def func(head: ListNode, tail: ListNode): TreeNode = {
    if (head == tail) return null
    var slow = head
    var fast = head
    while (fast != tail && fast.next != tail) {
      slow = slow.next
      fast = fast.next.next
    }
    val cur = new TreeNode(slow.x)
    cur.left = func(head, slow)
    cur.right = func(slow.next, tail)
    cur
  }
}
