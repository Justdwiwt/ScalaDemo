package leetCode._400

import scala.collection.mutable

object Solution_325 {
  def maxSubArrayLen(nums: Array[Int], k: Int): Int = {
    var m = mutable.HashMap.empty[Int, Int]
    m += 0 -> -1
    var sum = 0
    var res = 0
    nums.indices.foreach(i => {
      sum += nums(i)
      if (m.contains(sum - k)) res = res.max(i - m(sum - k))
      if (!m.contains(sum)) m += sum -> i
    })
    res
  }
}
