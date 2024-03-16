package leetCode._2500

object Solution_2484 {
  def countPalindromes(s: String): Int = {
    val arr = Array.fill(s.length, 10, 10, 5)(-1L)

    def dfs(i: Int, first: Int, second: Int, chosen: Int): Long = {
      if (chosen == 5) 1
      else if (i == s.length) 0
      else if (arr(i)(first)(second)(chosen) != -1L) arr(i)(first)(second)(chosen)
      else {
        val skip = dfs(i + 1, first, second, chosen)
        val choose1st = if (chosen != 0) 0 else dfs(i + 1, s(i) - '0', second, chosen = 1)
        val choose2nd = if (chosen != 1) 0 else dfs(i + 1, first, s(i) - '0', chosen = 2)
        val choose3rd = if (chosen != 2) 0 else dfs(i + 1, first, second, chosen = 3)
        val choose4th = if (chosen != 3 || s(i) - '0' != second) 0 else dfs(i + 1, first, second, chosen = 4)
        val choose5th = if (chosen != 4 || s(i) - '0' != first) 0 else dfs(i + 1, first, second, chosen = 5)
        val res = (skip + choose1st + choose2nd + choose3rd + choose4th + choose5th) % 1000000007
        arr(i)(first)(second)(chosen) = res
        res
      }
    }

    dfs(0, 0, 0, 0).toInt
  }
}
