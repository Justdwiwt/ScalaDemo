package leetCode._100

import leetCode.TreeNode

object Solution_100 {
  def isSameTree(p: TreeNode, q: TreeNode): Boolean = {
    if (p == q) return true
    if (p == null || q == null) return false
    if (p.value != q.value) return false
    isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
  }
}
