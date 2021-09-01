package leetCode

object LCP_34 {
  def maxValue(root: TreeNode, k: Int): Int = {

    def dfs(root: TreeNode, k: Int): Array[Int] = {
      if (root == null) return Array(k + 1)

      val left = dfs(root.left, k)
      val right = dfs(root.right, k)
      val dp = Array.fill(k + 1)(0)

      var l = 0
      var r = 0

      (0 to k).foreach(i => {
        l = l.max(left(i))
        r = r.max(right(i))
      })

      dp(0) = l + r

      (1 to k).foreach(i => (0 until i).foreach(j =>
        dp(i) = dp(i).max(left(j) + right(i - j - 1) + root.value)
      ))

      dp
    }

    dfs(root, k).max
  }
}
