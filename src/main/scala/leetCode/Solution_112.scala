package leetCode

object Solution_112 {
  def hasPathSum(root: TreeNode, sum: Int): Boolean = {
    if (root == null) return false
    if (root.left == null && root.right == null && root.value == sum) return true
    hasPathSum(root.left, sum - root.value) || hasPathSum(root.right, sum - root.value)
  }
}
