package leetCode

object Solution_124 {
  def maxPathSum(root: TreeNode): Int = {
    var res = Int.MinValue

    def f(root: TreeNode): Int = {
      if (root == null) return 0
      val l = 0.max(f(root.left))
      val r = 0.max(f(root.right))
      res = res.max(root.value + l + r)
      l.max(r) + root.value
    }

    f(root)
    res
  }
}
