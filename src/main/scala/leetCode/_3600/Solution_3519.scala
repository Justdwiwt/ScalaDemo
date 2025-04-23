package leetCode._3600

object Solution_3519 {
  private def trans(s: String, b: Int): List[Int] = {
    @scala.annotation.tailrec
    def loop(x: BigInt, acc: List[Int]): List[Int] =
      if (x == 0) acc
      else loop(x / b, (x % b).toInt :: acc)

    loop(BigInt(s), List.empty[Int])
  }

  def countNumbers(l: String, r: String, b: Int): Int = {
    val high = trans(r, b)
    val low = trans(l, b)
    val n = high.length
    val paddedLow = List.fill(n - low.length)(0) ++ low
    val cache = collection.mutable.Map[(Int, BigInt, Boolean, Boolean), BigInt]()

    def dfs(i: Int, pre: BigInt, limitLow: Boolean, limitHigh: Boolean): BigInt =
      if (i == n) BigInt(1)
      else cache.get((i, pre, limitLow, limitHigh)) match {
        case Some(ans) => ans
        case None =>
          val lo = if (limitLow) BigInt(paddedLow(i)) else BigInt(0)
          val hi = if (limitHigh) BigInt(high(i)) else BigInt(b - 1)
          val range = (lo.intValue.max(pre.intValue) to hi.intValue).toList
          val r = range.foldLeft(BigInt(0))((acc, d) => acc + dfs(i + 1, BigInt(d), limitLow && d == lo.intValue, limitHigh && d == hi.intValue))
          cache((i, pre, limitLow, limitHigh)) = r
          r
      }

    val res = dfs(0, BigInt(0), limitLow = true, limitHigh = true)
    (res % 1000000007).toInt
  }
}
