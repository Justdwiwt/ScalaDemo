package leetCode

object Solution_111 {
  def minDepth(root: TreeNode): Int = {
    if (root == null) return 0
    if (root.left == null) return 1 + minDepth(root.right)
    if (root.right == null) return 1 + minDepth(root.left)
    1 + math.min(minDepth(root.left), minDepth(root.right))
  }
}
