package leetCode

import scala.util.control.Breaks._

object Solution_2920 {
  def maximumPoints(edges: Array[Array[Int]], coins: Array[Int], k: Int): Int = {
    val n = coins.length
    val arr = Array.fill(n)(List.empty[Int])
    edges.foreach(e => {
      val x = e.head
      val y = e(1)
      arr(x) = y :: arr(x)
      arr(y) = x :: arr(y)
    })
    val memo = Array.fill(n, 14)(-1)
    dfs(0, 0, -1, memo, arr, coins, k)
  }

  private def dfs(i: Int, j: Int, fa: Int, memo: Array[Array[Int]], g: Array[List[Int]], coins: Array[Int], k: Int): Int = {
    if (memo(i)(j) != -1) return memo(i)(j)
    var res1 = (coins(i) >> j) - k
    var res2 = coins(i) >> (j + 1)
    g(i).foreach(ch => breakable({
      if (ch == fa) break
      res1 += dfs(ch, j, i, memo, g, coins, k)
      if (j < 13) res2 += dfs(ch, j + 1, i, memo, g, coins, k)
    }))
    memo(i)(j) = res1.max(res2)
    memo(i)(j)
  }
}
