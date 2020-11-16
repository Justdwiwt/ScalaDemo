package leetCode

object Solution_663 {
  def checkEqualTree(root: TreeNode): Boolean = {
    val sum = g(root)
    if ((sum & 1) != 0) return false
    if (sum == 0) return f(root.left, sum / 2) || f(root.right, sum / 2)
    f(root, sum / 2)
  }

  def f(root: TreeNode, halfSum: Int): Boolean = {
    if (root == null) return false
    if (g(root) == halfSum) return true
    f(root.left, halfSum) || f(root.right, halfSum)
  }

  def g(root: TreeNode): Int = if (root == null) 0 else root.value + g(root.left) + g(root.right)
}
