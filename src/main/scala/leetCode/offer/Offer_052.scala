package leetCode.offer

import leetCode.TreeNode

object Offer_052 {
  def increasingBST(root: TreeNode): TreeNode = func(root, null)

  def func(node: TreeNode, pre: TreeNode): TreeNode = node match {
    case null => pre
    case _ =>
      val res = func(node.left, node)
      node.left = null
      node.right = func(node.right, pre)
      res
  }
}
