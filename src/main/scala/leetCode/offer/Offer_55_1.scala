package leetCode.offer

import leetCode.TreeNode

object Offer_55_1 {
  def maxDepth(root: TreeNode): Int = root match {
    case null => 0
    case _ =>
      1 + maxDepth(root.left).max(maxDepth(root.right))
  }
}
