package leetCode

object Code_04_04 {
  def isBalanced(root: TreeNode): Boolean =
    root == null || ((f(root.left) - f(root.right)).abs < 2 && isBalanced(root.left) && isBalanced(root.right))

  def f(root: TreeNode): Int =
    if (root == null) 0
    else f(root.left).max(f(root.right)) + 1
}
