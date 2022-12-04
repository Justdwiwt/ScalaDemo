package leetCode

import scala.collection.mutable

object Solution_2461 {
  def maximumSubarraySum(nums: Array[Int], k: Int): Long = {
    var sum = 0L
    val st = mutable.HashSet.empty[Int]
    var l = 0
    var r = 0
    var res = 0L
    while (r < nums.length) {
      sum += nums(r)
      if (st.contains(nums(r))) {
        while (l < r && nums(r) != nums(l)) {
          st.remove(nums(l))
          sum -= nums(l)
          l += 1
        }
        sum -= nums(l)
        l += 1
      } else st += nums(r)
      if (r - l + 1 == k) {
        res = res.max(sum)
        st.remove(nums(l))
        sum -= nums(l)
        l += 1
      }
      r += 1
    }
    res
  }
}
