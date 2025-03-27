package leetCode._3500

object Solution_3490 {
  def beautifulNumbers(l: Int, r: Int): Int = {
    val low = l.toString.map(_.asDigit)
    val high = r.toString.map(_.asDigit)
    val n = high.length
    val diffLH = n - low.length

    def dfs(
             i: Int,
             m: BigInt,
             s: Int,
             limitLow: Boolean,
             limitHigh: Boolean,
             memo: Map[(Int, BigInt, Int, Boolean, Boolean), Int]
           ): (Int, Map[(Int, BigInt, Int, Boolean, Boolean), Int]) = {
      if (i == n) return (if (s > 0 && m % s == 0) 1 else 0, memo)
      memo.get((i, m, s, limitLow, limitHigh)) match {
        case Some(res) => (res, memo)
        case None =>
          val lo = if (limitLow && i >= diffLH) low(i - diffLH) else 0
          val hi = if (limitHigh) high(i) else 9

          val (res, newMemo) = (lo to hi).foldLeft((0, memo)) { case ((sum, accMemo), d) =>
            val newM = if (s == 0) BigInt(d) else m * d
            val (count, updatedMemo) = dfs(i + 1, newM, s + d, limitLow && d == lo, limitHigh && d == hi, accMemo)
            (sum + count, updatedMemo)
          }

          (res, newMemo + ((i, m, s, limitLow, limitHigh) -> res))
      }
    }

    dfs(0, BigInt(1), 0, limitLow = true, limitHigh = true, Map.empty)._1
  }
}
