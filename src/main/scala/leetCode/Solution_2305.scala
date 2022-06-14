package leetCode

object Solution_2305 {
  def distributeCookies(cookies: Array[Int], k: Int): Int = {
    var res = Integer.MAX_VALUE

    def dfs(i: Int, curr: Array[Int]): Unit =
      if (i == cookies.length)
        res = res.min(curr.max)
      else (0 until k).foreach(j => {
        curr(j) += cookies(i)
        dfs(i + 1, curr)
        curr(j) -= cookies(i)
      })

    dfs(0, Array.ofDim[Int](k))
    res
  }
}
