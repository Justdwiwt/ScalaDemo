package leetCode

import scala.collection.mutable

object Solution_2944 {
  def minimumCoins(prices: Array[Int]): Int = {
    val m = mutable.Map.empty[Int, Int]

    def f(i: Int): Int =
      m.getOrElseUpdate(i, if (i >= prices.length) 0 else prices(i) + (i + 1 to (2 * i + 2)).map(f).min)

    f(0)
  }
}
