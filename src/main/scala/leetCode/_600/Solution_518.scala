package leetCode._600

import scala.collection.mutable

object Solution_518 {
  def change(amount: Int, coins: Array[Int]): Int = {
    val m = mutable.HashMap.empty[(Int, Int), Int]

    def f(amount: Int, coins: Array[Int], s: Int): Int = m.get((amount, s)) match {
      case Some(v) => v
      case None =>
        val r =
          if (amount < 0) 0
          else if (amount == 0) 1
          else s.until(coins.length).map(i => if (amount - coins(i) < 0) 0 else f(amount - coins(i), coins, i)).sum
        m += ((amount, s) -> r)
        r
    }

    f(amount, coins.sorted, 0)
  }
}
