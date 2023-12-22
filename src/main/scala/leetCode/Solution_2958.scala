package leetCode

import scala.collection.mutable

object Solution_2958 {
  def maxSubarrayLength(nums: Array[Int], k: Int): Int = {
    val m = mutable.Map.empty[Int, Int].withDefaultValue(0)
    val n = nums.length

    @scala.annotation.tailrec
    def f(l: Int, r: Int, res: Int, flag: Boolean): Int = {
      if (r == n) return res
      if (flag) m.update(nums(r), m(nums(r)) + 1)
      if (m(nums(r)) <= k) f(l, r + 1, res.max((r - l) + 1), flag = true)
      else {
        m.update(nums(l), m(nums(l)) - 1)
        f(l + 1, r, res, flag = false)
      }
    }

    f(0, 0, 0, flag = true)
  }
}
