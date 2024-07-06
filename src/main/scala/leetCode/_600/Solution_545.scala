package leetCode._600

import leetCode.TreeNode

object Solution_545 {
  def boundaryOfBinaryTree(root: TreeNode): List[Int] = {
    val res = scala.collection.mutable.ListBuffer.empty[Int]
    dfs(root, leftBound = true, rightBound = true, res)
    res.toList
  }

  private def dfs(node: TreeNode, leftBound: Boolean, rightBound: Boolean, res: scala.collection.mutable.ListBuffer[Int]): Unit = {
    if (node == null) return

    if (leftBound) res += node.value
    else if (node.left == null && node.right == null) {
      res += node.value
      return
    }

    dfs(node.left, leftBound, !leftBound && rightBound && node.right == null, res)
    dfs(node.right, !rightBound && leftBound && node.left == null, rightBound, res)

    if (!leftBound && rightBound) res += node.value
  }
}
