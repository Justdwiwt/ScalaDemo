package leetCode

object Offer_28 {
  def isSymmetric(root: TreeNode): Boolean = f(root, root)

  def f(left: TreeNode, right: TreeNode): Boolean = {
    if (left == null && right == null) return true
    if (left == null || right == null) return false
    (left.value == right.value) && f(left.left, right.right) && f(left.right, right.left)
  }
}
