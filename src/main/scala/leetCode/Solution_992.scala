package leetCode

import scala.collection.mutable

object Solution_992 {
  def subarraysWithKDistinct(array: Array[Int], k: Int): Int = {
    def f(p: Int): Int = {
      val m = mutable.Map[Int, Int]()
      var res = 0
      var i, j = 0
      while (i < array.length) {
        m += array(i) -> (m.getOrElse(array(i), 0) + 1)
        while (m.size > p && j <= i) {
          m += array(j) -> (m(array(j)) - 1)
          if (m(array(j)) == 0) m -= array(j)
          j += 1
        }
        res += i - j + 1
        i += 1
      }
      res
    }

    f(k) - f(k - 1)
  }
}
