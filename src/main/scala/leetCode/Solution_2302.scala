package leetCode

object Solution_2302 {
  def countSubarrays(nums: Array[Int], k: Long): Long = {
    var res = 0L
    var s = 0L
    var l, r = 0
    while (r < nums.length) {
      s += nums(r)
      r += 1
      while (l < r && (r - l).toLong * s >= k) {
        s -= nums(l)
        l += 1
      }
      res += r - l
    }
    res
  }
}
