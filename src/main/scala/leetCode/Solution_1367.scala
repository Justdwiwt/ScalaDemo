package leetCode

object Solution_1367 {
  def isSubPath(head: ListNode, root: TreeNode): Boolean = (head, root) match {
    case (null, _) => true
    case (_, null) => false
    case _ =>
      if (f(head, root)) return true
      isSubPath(head, root.left) || isSubPath(head, root.right)
  }

  def f(head: ListNode, root: TreeNode): Boolean = (head, root) match {
    case (null, _) => true
    case (_, null) => false
    case _ =>
      if (root.value != head.x) return false
      f(head.next, root.left) || f(head.next, root.right)
  }
}
