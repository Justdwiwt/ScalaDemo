package leetCode

object Solution_1080 {
  def check(root: TreeNode): Boolean = root.left == null && root.right == null

  def sufficientSubset(root: TreeNode, limit: Int): TreeNode = root match {
    case null => null
    case r if check(r) => if (r.value < limit) null else r
    case r =>
      r.left = sufficientSubset(r.left, limit - r.value)
      r.right = sufficientSubset(r.right, limit - r.value)
      if (check(r)) null else r
  }
}
