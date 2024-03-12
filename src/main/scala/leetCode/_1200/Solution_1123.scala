package leetCode._1200

import leetCode.TreeNode

object Solution_1123 {
  @scala.annotation.tailrec
  def lcaDeepestLeaves(root: TreeNode): TreeNode = root match {
    case null => null
    case _ =>
      val left = depth(root.left)
      val right = depth(root.right)
      if (left == right) root
      else if (left > right) lcaDeepestLeaves(root.left)
      else lcaDeepestLeaves(root.right)
  }

  def depth(root: TreeNode): Int = if (root == null) 0 else 1 + depth(root.left).max(depth(root.right))
}
