package leetCode._2300

import scala.util.Sorting

object Solution_2234 {
  private var flowers: Array[Int] = _
  private var sum: Array[Long] = _

  def maximumBeauty(flowers: Array[Int], newFlowers: Long, target: Int, full: Int, partial: Int): Long = {
    var remainingFlowers = newFlowers
    var res = 0L
    Sorting.quickSort(flowers)
    this.flowers = flowers
    val n = flowers.length
    sum = Array.fill(n + 1)(0L)
    flowers.indices.foreach(i => sum(i + 1) = sum(i) + flowers(i))
    var m = n
    while (m > 0 && flowers(m - 1) >= target) m -= 1
    while (remainingFlowers >= 0) {
      var low = 1
      var high = target - 1
      while (low <= high) {
        val mid = (low + high) >>> 1
        if (check(m, remainingFlowers, mid)) low = mid + 1
        else high = mid - 1
      }
      res = res.max(full.toLong * (n - m) + partial.toLong * high)
      if (m == 0) return res
      remainingFlowers -= (target - flowers(m - 1))
      m -= 1
    }
    res
  }

  private def check(m: Int, remainingFlowers: Long, value: Int): Boolean = {
    if (m == 0) return false
    var low = 0
    var high = m - 1
    while (low <= high) {
      val mid = (low + high) >>> 1
      if (flowers(mid) < value) low = mid + 1
      else high = mid - 1
    }
    low.toLong * value - sum(low) <= remainingFlowers
  }
}
