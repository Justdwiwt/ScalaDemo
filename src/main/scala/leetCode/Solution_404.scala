package leetCode

object Solution_404 {
  def sumOfLeftLeaves(root: TreeNode): Int = {
    def f(r: TreeNode, isLeft: Boolean): Int = (r, isLeft) match {
      case (null, _) => 0
      case (r, true) if r.left == null && r.right == null => r.value
      case (r, _) => f(r.left, isLeft = true) + f(r.right, isLeft = false)
    }

    f(root, isLeft = false)
  }
}
