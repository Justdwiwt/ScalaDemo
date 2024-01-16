package leetCode

import scala.collection.mutable

object Solution_2719 {
  val M = 1000000007

  def count(num1: String, num2: String, minSum: Int, maxSum: Int): Int = {
    val upLimit = num2.map(_.asDigit).toArray
    val downLimit = num1.reverse.padTo(num2.length, '0').reverse.map(_.asDigit).toArray
    val m = mutable.Map.empty[(Int, Int, Boolean, Boolean, Boolean), Int]

    def f(i: Int = 0, s: Int = 0, valid: Boolean = false, dLimit: Boolean = true, uLimit: Boolean = true): Int = {
      if (i == num2.length) return if (valid && s >= minSum && s <= maxSum) 1 else 0

      val cacheKey = (i, s, valid, dLimit, uLimit)
      if (m.contains(cacheKey)) return m(cacheKey)

      val down = if (dLimit) downLimit(i) else 0
      val up = if (uLimit) upLimit(i) else 9
      var res = 0

      (down to up).foreach(d => res = (res + f(i + 1, s + d, valid || d != 0, dLimit && d == down, uLimit && d == up)) % M)

      m(cacheKey) = res
      res
    }

    f()
  }
}
