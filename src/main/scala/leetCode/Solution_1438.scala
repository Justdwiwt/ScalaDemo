package leetCode

object Solution_1438 {
  def longestSubarray(nums: Array[Int], limit: Int): Int = {
    var left = 0
    var right = 0
    if (nums.length < 2) return nums.length
    var mxn = 0
    var mnn = 0
    var res = 0
    while (right < nums.length) {
      if (right == left) {
        mxn = right
        mnn = right
      } else {
        if (nums(right) >= nums(mxn)) mxn = right
        if (nums(right) <= nums(mnn)) mnn = right
      }
      if (nums(mxn) - nums(mnn) <= limit) right += 1
      else {
        while (left < mxn && left < mnn) left += 1
        left += 1
        right = left
      }
      res = res.max(right - left)
    }
    res
  }
}
