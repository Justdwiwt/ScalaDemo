package leetCode._200

import leetCode.TreeNode

object Solution_112 {
  def hasPathSum(root: TreeNode, sum: Int): Boolean = (root, sum) match {
    case (null, _) => false
    case (r, _) if r.left == null && r.right == null => r.value == sum
    case (r, _) => hasPathSum(r.left, sum - r.value) || hasPathSum(r.right, sum - r.value)
  }
}
