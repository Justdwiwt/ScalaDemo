package leetCode

import scala.collection.mutable

object Solution_375 {
  def getMoneyAmount(n: Int): Int = {
    val m: mutable.Map[(Int, Int), Int] = mutable.Map().withDefaultValue(-1)

    def f(l: Int, r: Int): Int = {
      if (l >= r) return 0
      if (m((l, r)) != -1) return m((l, r))
      var cos = 100000
      (l to r).foreach(x => cos = cos.min(x + f(l, x - 1).max(f(x + 1, r))))
      m((l, r)) = cos
      cos
    }

    f(1, n)
  }
}
