package leetCode._3500

import scala.collection.mutable.ArrayBuffer

object Solution_3430 {
  private def count(m: Int, k: Int): Long =
    if (m > k) (m * 2L - k + 1) * k / 2
    else (m + 1L) * m / 2

  private def sumSubarrayMins(nums: Array[Int], k: Int): Long = {
    val n = nums.length
    var res = 0L
    val st = ArrayBuffer(-1)
    (0 to n).foreach(r => {
      val x = if (r < n) nums(r) else Int.MinValue
      while (st.length > 1 && nums(st.last) >= x) {
        val i = st.remove(st.length - 1)
        val l = st.last
        val cnt = count(r - l - 1, k) - count(i - l - 1, k) - count(r - i - 1, k)
        res += nums(i).toLong * cnt
      }
      st.append(r)
    })
    res
  }

  def minMaxSubarraySum(nums: Array[Int], k: Int): Long = {
    val negatedNums = nums.map(-_)
    sumSubarrayMins(nums, k) - sumSubarrayMins(negatedNums, k)
  }
}
