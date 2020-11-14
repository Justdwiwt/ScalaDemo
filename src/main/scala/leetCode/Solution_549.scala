package leetCode

object Solution_549 {
  def longestConsecutive(root: TreeNode): Int = {
    var mx = 0

    def dfs(node: TreeNode, pre: Int): Array[Int] = {
      if (node == null) return Array(1, 1)
      val left = dfs(node.left, node.value)
      val right = dfs(node.right, node.value)
      mx = mx.max(left.head + right(1) - 1)
      mx = mx.max(left(1) + right.head - 1)
      var p = 1
      var q = 1
      if (node.value + 1 == pre) p = left.head.max(right.head) + 1
      if (node.value - 1 == pre) q = left(1).max(right(1)) + 1
      Array(p, q)
    }

    dfs(root, 0)
    mx
  }
}
