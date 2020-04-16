package leetCode

object Solution_104 {
  def maxDepth(root: TreeNode): Int = root match {
    case null => 0
    case _ =>
      1 + maxDepth(root.left).max(maxDepth(root.right))
  }
}
