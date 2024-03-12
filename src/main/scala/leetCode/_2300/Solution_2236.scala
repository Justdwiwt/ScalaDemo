package leetCode._2300

import leetCode.TreeNode

object Solution_2236 {
  def checkTree(root: TreeNode): Boolean =
    root.value == root.left.value + root.right.value
}
