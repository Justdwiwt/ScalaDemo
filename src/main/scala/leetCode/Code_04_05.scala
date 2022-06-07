package leetCode

object Code_04_05 {
  def isValidBST(root: TreeNode): Boolean =
    f(root, Long.MinValue, Long.MaxValue)

  def f(root: TreeNode, min: Long, max: Long): Boolean =
    root == null || (root.value > min && root.value < max && f(root.left, min, root.value) && f(root.right, root.value, max))
}
