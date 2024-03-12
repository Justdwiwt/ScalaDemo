package leetCode._700

import leetCode.TreeNode

object Solution_623 {
  def addOneRow(root: TreeNode, v: Int, d: Int): TreeNode = {
    if (d == 0 || d == 1) {
      val node = new TreeNode(v)
      if (d > 0) node.left = root else node.right = root
      return node
    }
    if (root != null && d > 1) {
      root.left = addOneRow(root.left, v, if (d > 2) d - 1 else 1)
      root.right = addOneRow(root.right, v, if (d > 2) d - 1 else 0)
    }
    root
  }
}
