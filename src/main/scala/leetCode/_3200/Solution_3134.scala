package leetCode._3200

import scala.collection.mutable

object Solution_3134 {
  def medianOfUniquenessArray(nums: Array[Int]): Int = {
    val n = nums.length
    val k = (n.toLong * (n + 1) / 2 + 1) / 2

    def check(nums: Array[Int], upper: Int, k: Long): Boolean = {
      var cnt = 0L
      var l = 0
      val freq = mutable.HashMap.empty[Int, Int]
      var r = 0
      while (r < nums.length) {
        freq(nums(r)) = freq.getOrElse(nums(r), 0) + 1
        while (freq.size > upper) {
          val out = nums(l)
          l += 1
          if (freq(out) == 1) freq.remove(out)
          else freq(out) -= 1
        }
        cnt += r - l + 1
        if (cnt >= k) return true
        r += 1
      }
      false
    }

    var l = 0
    var r = n
    while (l + 1 < r) {
      val mid = (l + r) >>> 1
      if (check(nums, mid, k)) r = mid
      else l = mid
    }
    r
  }
}
