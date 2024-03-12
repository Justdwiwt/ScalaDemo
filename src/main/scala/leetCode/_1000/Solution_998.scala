package leetCode._1000

import leetCode.TreeNode

object Solution_998 {
  def insertIntoMaxTree(root: TreeNode, `val`: Int): TreeNode = root match {
    case null => new TreeNode(`val`)
    case node if node.value < `val` =>
      val treeNode = new TreeNode(`val`)
      treeNode.left = node
      treeNode
    case node =>
      val treeNode = new TreeNode(node.value)
      treeNode.left = node.left
      treeNode.right = insertIntoMaxTree(node.right, `val`)
      treeNode
  }
}
