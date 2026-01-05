package leetCode._3800

object Solution_3704 {
  private def twoSumWays(t: Int): Long =
    math.max(math.min(t - 1, 19 - t), 0).toLong

  def countNoZeroPairs(n: Long): Long = {
    val digits = n.toString.map(_ - '0')
    val m = digits.length
    val memo = scala.collection.mutable.Map.empty[(Int, Boolean, Boolean), Long]

    def dfs(i: Int, borrowed: Boolean, isNum: Boolean): Long = memo.getOrElseUpdate((i, borrowed, isNum), {
      if (i < 0) {
        if (borrowed) 0L else 1L
      } else {
        val d = digits(i) - (if (borrowed) 1 else 0)

        val bothNonZero =
          if (!isNum) 0L
          else
            dfs(i - 1, borrowed = false, isNum = true) * twoSumWays(d) +
              dfs(i - 1, borrowed = true, isNum = true) * twoSumWays(d + 10)

        val withLeadingZero =
          if (i == m - 1) 0L
          else if (d != 0)
            dfs(i - 1, d < 0, isNum = false) * (if (isNum) 2 else 1)
          else if (i == 0) 1L
          else 0L

        bothNonZero + withLeadingZero
      }
    })

    dfs(m - 1, borrowed = false, isNum = true)
  }
}
