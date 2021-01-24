package leetCode

object Solution_543 {
  def diameterOfBinaryTree(root: TreeNode): Int = {
    def f(root: TreeNode): (Int, Int) =
      if (root == null) (0, 0)
      else {
        val (leftMax, leftDepth) = f(root.left)
        val (rightMax, rightDepth) = f(root.right)
        val diameter = Seq(leftMax, rightMax, leftDepth + rightDepth).max
        (diameter, 1 + leftDepth.max(rightDepth))
      }

    f(root)._1
  }
}
