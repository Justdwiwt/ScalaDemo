package leetCode._700

import leetCode.TreeNode

object Solution_687 {
  def longestUnivaluePath(root: TreeNode): Int = {
    if (root == null) return 0
    val sub = longestUnivaluePath(root.left).max(longestUnivaluePath(root.right))
    sub.max(func(root.left, root.value) + func(root.right, root.value))
  }

  def func(node: TreeNode, parent: Int): Int = {
    if (node == null || node.value != parent) return 0
    1 + func(node.left, node.value).max(func(node.right, node.value))
  }
}
