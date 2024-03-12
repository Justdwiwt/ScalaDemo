package leetCode._400

import scala.collection.mutable

object Solution_312 {
  def maxCoins(iNums: Array[Int]): Int = {
    val arr = 1 +: iNums.filter(_ > 0) :+ 1
    val m = mutable.Map.empty[(Int, Int), Int]

    def f(l: Int, r: Int): Int =
      if (l >= r) 0
      else m.getOrElse((l, r), {
        m((l, r)) = Range(l + 1, r)
          .map(cur => arr(l) * arr(cur) * arr(r) + f(l, cur) + f(cur, r))
          ./:(0)((mx, curr) => mx.max(curr))
        m((l, r))
      })

    f(0, arr.length - 1)
  }
}
