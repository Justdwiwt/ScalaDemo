package leetCode

object Solution_2560 {
  def minCapability(nums: Array[Int], k: Int): Int = {
    var left = 0
    var right = (1e9 + 7).toInt
    var mid = (left + right) >>> 1
    while (left < right) {
      var i = 0
      var j = 0
      while (i < nums.length && j < k) {
        if (nums(i) <= mid) {
          j += 1
          i += 1
        }
        i += 1
      }
      if (j >= k) right = mid
      else left = mid + 1
      mid = left + (right - left) / 2
    }
    left
  }
}
