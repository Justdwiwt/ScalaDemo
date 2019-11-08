package leetCode

import scala.util.control.Breaks._

object Solution_887 {
  def superEggDrop(K: Int, N: Int): Int = {
    var left = 1
    var right = N
    while (left < right) {
      val mid = left + (right - left) / 2
      if (func(mid, K, N) < N) left = mid + 1
      else right = mid
    }
    right
  }

  def func(x: Int, k: Int, n: Int): Int = {
    var res = 0
    var r = 1
    breakable {
      (1 to k).foreach(i => {
        r *= x - i + 1
        r /= i
        res += r
        if (res >= n) break
      })
    }
    res
  }
}
