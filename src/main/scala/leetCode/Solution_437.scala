package leetCode

object Solution_437 {
  def pathSum(root: TreeNode, sum: Int): Int = root match {
    case null => 0
    case _ => sumUp(root, 0, sum) + pathSum(root.left, sum) + pathSum(root.right, sum)
  }

  def sumUp(node: TreeNode, pre: Int, sum: Int): Int = node match {
    case null => 0
    case _ =>
      val cur = pre + node.value
      if (cur == sum) 1 else 0 + sumUp(node.left, cur, sum) + sumUp(node.right, cur, sum)
  }
}
