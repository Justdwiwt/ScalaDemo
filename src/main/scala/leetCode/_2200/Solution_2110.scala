package leetCode._2200

object Solution_2110 {
  def getDescentPeriods(prices: Array[Int]): Long = (prices :+ Int.MaxValue)
    .foldLeft(0L, 0, prices.head) { case ((cnt, length, pre), cur) =>
      if (cur == pre - 1) (cnt, length + 1, cur)
      else (cnt + (length.toLong * (length + 1) / 2), 1, cur)
    }
    ._1
}
