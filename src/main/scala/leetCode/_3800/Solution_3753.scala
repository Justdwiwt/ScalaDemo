package leetCode._3800

object Solution_3753 {
  def totalWaviness(num1: Long, num2: Long): Long = {
    val low = num1.toString.map(_ - '0').toArray
    val high = num2.toString.map(_ - '0').toArray
    val n = high.length
    val diff = n - low.length

    val memo = collection.mutable.Map.empty[(Int, Int, Int, Int, Boolean, Boolean), Long]

    def dfs(i: Int, w: Int, lastCmp: Int, lastD: Int, limL: Boolean, limH: Boolean): Long = {
      val key = (i, w, lastCmp, lastD, limL, limH)

      memo.getOrElseUpdate(key, {
        if (i == n) w.toLong
        else {
          val lo = if (limL && i >= diff) low(i - diff) else 0
          val hi = if (limH) high(i) else 9
          val isNum = !limL || i > diff

          (lo to hi).foldLeft(0L)((acc, d) => {
            val c =
              if (!isNum) 0
              else if (d > lastD) 1
              else if (d < lastD) -1
              else 0

            val nw = if (c * lastCmp < 0) w + 1 else w

            acc + dfs(i + 1, nw, c, d, limL && d == lo, limH && d == hi)
          })
        }
      })
    }

    dfs(0, 0, 0, 0, limL = true, limH = true)
  }
}
