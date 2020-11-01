package leetCode

object Solution_333 {
  def largestBSTSubtree(root: TreeNode): Int = root match {
    case null => 0
    case _ =>
      if (isBST(root)) return cnt(root)
      largestBSTSubtree(root.left).max(largestBSTSubtree(root.right))
  }

  def isBST(root: TreeNode): Boolean = isBST(root, Int.MinValue, Int.MaxValue)

  def isBST(root: TreeNode, mn: Int, mx: Int): Boolean = root match {
    case null => true
    case _ => mn < root.value && root.value < mx && isBST(root.left, mn, root.value) && isBST(root.right, root.value, mx)
  }

  def cnt(root: TreeNode): Int = root match {
    case null => 0
    case _ => 1 + cnt(root.left) + cnt(root.right)
  }
}
