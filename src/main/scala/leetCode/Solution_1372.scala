package leetCode

object Solution_1372 {
  def longestZigZag(root: TreeNode): Int = {
    var res = 0
    dfs(root, flag = true)

    def dfs(root: TreeNode, flag: Boolean): Int = root match {
      case null => 0
      case _ =>
        val r = dfs(root.right, flag = false)
        val l = dfs(root.left, flag = true)
        val mx = if (l > r) l else r
        if (mx > res) res = mx
        if (flag) r + 1 else l + 1
    }

    res
  }
}
