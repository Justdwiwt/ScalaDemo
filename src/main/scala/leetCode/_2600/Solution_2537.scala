package leetCode._2600

import scala.collection.mutable

object Solution_2537 {
  def countGood(nums: Array[Int], k: Int): Long = {
    var len = nums.length
    var res = 0L
    var m = mutable.HashMap.empty[Int, Int]
    var l, r, cnt = 0
    while (r < len) {
      cnt += m.getOrElse(nums(r), 0)
      m += nums(r) -> (m.getOrElse(nums(r), 0) + 1)
      r += 1
      while (cnt >= k) {
        res += len - r + 1
        m += nums(l) -> (m.getOrElse(nums(l), 0) - 1)
        cnt -= m(nums(l))
        l += 1
      }
    }
    res
  }
}
