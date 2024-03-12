package leetCode._700

import leetCode.TreeNode

object Solution_671 {
  def findSecondMinimumValue(root: TreeNode): Int = root.left match {
    case null => -1
    case _ =>
      val left = if (root.left.value == root.value) findSecondMinimumValue(root.left) else root.left.value
      val right = if (root.right.value == root.value) findSecondMinimumValue(root.right) else root.right.value
      if (left == -1 || right == -1) left.max(right) else left.min(right)
  }
}
