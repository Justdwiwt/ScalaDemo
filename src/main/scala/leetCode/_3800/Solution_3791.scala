package leetCode._3800

object Solution_3791 {
  def countBalanced(low: Long, high: Long): Long = {
    if (high < 11) return 0L

    val lo = math.max(low, 11)
    val lowS = lo.toString.map(_ - '0').toArray
    val highS = high.toString.map(_ - '0').toArray
    val n = highS.length
    val diffLH = n - lowS.length

    val memo = collection.mutable.Map.empty[(Int, Int, Boolean, Boolean), Long]

    def dfs(i: Int, diff: Int, limitLow: Boolean, limitHigh: Boolean): Long = memo
      .getOrElseUpdate((i, diff, limitLow, limitHigh), {
        if (i == n) {
          if (diff == 0) 1L else 0L
        } else {
          val loDigit =
            if (limitLow && i >= diffLH) lowS(i - diffLH) else 0
          val hiDigit =
            if (limitHigh) highS(i) else 9

          (loDigit to hiDigit).map(d => {
            val ndiff = diff + (if ((i & 1) == 1) d else -d)
            dfs(
              i + 1,
              ndiff,
              limitLow && d == loDigit,
              limitHigh && d == hiDigit
            )
          }).sum
        }
      })

    dfs(0, 0, limitLow = true, limitHigh = true)
  }
}
