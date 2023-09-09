package leetCode

import scala.collection.mutable

object Solution_2845 {
  def countInterestingSubarrays(nums: List[Int], modulo: Int, k: Int): Long = {
    val m = mutable.HashMap.empty[Int, Int]
    var res = 0L
    var cnt = 0
    m += 0 -> 1
    nums.foreach(v => {
      if (v % modulo == k) cnt += 1
      res += m.getOrElse((cnt - k + modulo) % modulo, 0)
      m += cnt % modulo -> (m.getOrElse(cnt % modulo, 0) + 1)
    })
    res
  }
}
