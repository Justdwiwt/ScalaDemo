package leetCode._4000

import scala.collection.mutable.ArrayBuffer

object Solution_3920 {
  private def bisectRight(a: ArrayBuffer[Int], x: Int): Int = {
    var l = 0
    var r = a.length
    while (l < r) {
      val m = (l + r) >>> 1
      if (a(m) <= x) l = m + 1
      else r = m
    }
    l
  }

  def maxFixedPoints(nums: Array[Int]): Int = nums
    .indices
    .collect { case i if i >= nums(i) => (nums(i), i - nums(i)) }
    .sortBy { case (x, y) => (x, -y) }
    .foldLeft(ArrayBuffer.empty[Int]) {
      case (g, (_, h)) =>
        val j = bisectRight(g, h)
        if (j < g.length) g(j) = h
        else g += h
        g
    }
    .length
}
