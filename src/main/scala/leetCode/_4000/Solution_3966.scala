package leetCode._4000

object Solution_3966 {
  def goodIntegers(l: Long, r: Long, k: Int): Long = {
    val low = l.toString.map(_.asDigit)
    val high = r.toString.map(_.asDigit)

    val n = high.length
    val diff = n - low.length

    var memo = Map.empty[(Int, Int, Boolean, Boolean), Long]

    def dfs(i: Int, pre: Int, lowLimit: Boolean, highLimit: Boolean): Long =
      if (i == n) 1L
      else {
        val key = (i, pre, lowLimit, highLimit)

        memo.get(key) match {
          case Some(v) => v
          case None =>
            val lo = if (lowLimit && i >= diff) low(i - diff) else 0

            val hi = if (highLimit) high(i) else 9

            val skip =
              if (lowLimit && i < diff) dfs(i + 1, 0, lowLimit = true, highLimit = false)
              else 0L

            val start = if (lowLimit && i < diff) 1 else lo

            val first = lowLimit && i <= diff

            val res = skip + (start to hi).map(d => {
              if (first || math.abs(d - pre) <= k)
                dfs(i + 1, d, lowLimit && d == lo, highLimit && d == hi)
              else 0L
            }).sum

            memo += key -> res
            res
        }
      }

    dfs(0, 0, lowLimit = true, highLimit = true)
  }
}
