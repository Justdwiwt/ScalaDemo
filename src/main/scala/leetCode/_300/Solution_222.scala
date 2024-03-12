package leetCode._300

object Solution_222 {
  def countNodes(root: TreeNode): Int = root match {
    case null => 0
    case _ => 1 + countNodes(root.left) + countNodes(root.right)
  }
}
