package leetCode

object Solution_98 {
  def isValidBST(root: TreeNode): Boolean = func(root, Long.MinValue, Long.MaxValue)

  def func(root: TreeNode, mn: Long, mx: Long): Boolean = root match {
    case null => true
    case _ => if (root.value <= mn || root.value >= mx) return false
      func(root.left, mn, root.value) && func(root.right, root.value, mx)
  }
}
