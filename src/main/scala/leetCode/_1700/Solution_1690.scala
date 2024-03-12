package leetCode._1700

object Solution_1690 {
  def stoneGameVII(stones: Array[Int]): Int = {
    val pre = Array.fill(stones.length + 1)(0)
    stones.indices.foreach(i => pre(i + 1) = pre(i) + stones(i))
    dfs(0, stones.length - 1, pre, Array.ofDim[Int](stones.length, stones.length))
  }

  def dfs(l: Int, r: Int, pre: Array[Int], dp: Array[Array[Int]]): Int = {
    if (l == r) return 0
    if (dp(l)(r) != 0) return dp(l)(r)
    dp(l)(r) = (pre(r + 1) - pre(l + 1) - dfs(l + 1, r, pre, dp)).max(pre(r) - pre(l) - dfs(l, r - 1, pre, dp))
    dp(l)(r)
  }
}
