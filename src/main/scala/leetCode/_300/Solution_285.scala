package leetCode._300

object Solution_285 {
  def inorderSuccessor(root: TreeNode, p: TreeNode): TreeNode = (root, p) match {
    case (null, _) | (_, null) => null
    case (r, _) if r.value <= p.value => inorderSuccessor(r.right, p)
    case (r, _) =>
      val res = inorderSuccessor(r.left, p)
      if (res != null && res.value < r.value) res else r
  }
}
