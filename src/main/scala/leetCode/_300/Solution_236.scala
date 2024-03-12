package leetCode._300

object Solution_236 {
  def lowestCommonAncestor(root: TreeNode, p: TreeNode, q: TreeNode): TreeNode = root match {
    case null => null
    case _ =>
      if (root == p || root == q) return root
      val left = lowestCommonAncestor(root.left, p, q)
      val right = lowestCommonAncestor(root.right, p, q)
      if (left == null) return right
      if (right == null) return left
      root
  }
}
