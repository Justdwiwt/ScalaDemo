package leetCode._1800

import leetCode.TreeNode

object Solution_1740 {
  def findDistance(root: TreeNode, p: Int, q: Int): Int = {
    if (p == q) return 0
    val parent = f(root, p, q)
    find(parent, p) + find(parent, q)
  }

  private def f(root: TreeNode, p: Int, q: Int): TreeNode = {
    if (root == null || root.value == p || root.value == q) return root
    val left = f(root.left, p, q)
    val right = f(root.right, p, q)
    if (left != null && right != null) return root
    if (left != null) left else right
  }

  private def find(root: TreeNode, x: Int): Int = {
    if (root == null) return -1
    if (root.value == x) return 0
    val left = find(root.left, x)
    if (left >= 0) return left + 1
    val right = find(root.right, x)
    if (right >= 0) right + 1 else -1
  }
}
