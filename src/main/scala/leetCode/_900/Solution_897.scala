package leetCode._900

import leetCode.TreeNode

object Solution_897 {
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
