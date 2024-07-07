package leetCode._3300

object Solution_3208 {
  def numberOfAlternatingGroups(colors: Array[Int], k: Int): Int = {
    val n = colors.length

    @scala.annotation.tailrec
    def f(i: Int, cnt: Int, ans: Int): Int =
      if (i >= n * 2) ans
      else {
        val newCnt = if (i > 0 && colors(i % n) == colors((i - 1) % n)) 1 else cnt + 1
        val newAns = if (i >= n && newCnt >= k) ans + 1 else ans
        f(i + 1, newCnt, newAns)
      }

    f(0, 0, 0)
  }
}
