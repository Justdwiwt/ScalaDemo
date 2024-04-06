package leetCode._400

import scala.collection.immutable.HashMap

object Solution_325 {
  def maxSubArrayLen(nums: Array[Int], k: Int): Int = {
    @scala.annotation.tailrec
    def f(i: Int, sum: Int, m: Map[Int, Int], res: Int): Int = {
      if (i >= nums.length) res
      else {
        val newSum = sum + nums(i)
        val newRes = if (m.contains(newSum - k)) res.max(i - m(newSum - k)) else res
        val newMap = if (!m.contains(newSum)) m + (newSum -> i) else m
        f(i + 1, newSum, newMap, newRes)
      }
    }

    f(0, 0, HashMap(0 -> -1), 0)
  }
}
