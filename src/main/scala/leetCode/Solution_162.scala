package leetCode

object Solution_162 {
  def findPeakElement(nums: Array[Int]): Int = {
    var left = 0
    var right = nums.length - 1
    while (left < right) {
      val mid = left + (right - left >> 1)
      if (mid == nums.length - 1 || nums(mid) > nums(mid + 1)) right = mid
      else left = mid + 1
    }
    left
  }
}
