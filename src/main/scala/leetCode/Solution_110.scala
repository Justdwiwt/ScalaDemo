package leetCode

object Solution_110 {
  def isBalanced(root: TreeNode): Boolean = if (high(root) == -1) false else true

  def high(root: TreeNode): Int = root match {
    case null => 0
    case _ =>
      val l = high(root.left)
      if (l == -1) return -1
      val r = high(root.right)
      if (r == -1) return -1
      if (l - r >= -1 && l - r <= 1) l.max(r) + 1 else -1
  }
}
