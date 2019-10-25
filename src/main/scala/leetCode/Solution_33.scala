package leetCode

object Solution_33 {
  def search(nums: Array[Int], target: Int): Int = {
    var low = 0
    var high = nums.length - 1
    while (low <= high) {
      val mid = low + (high - low) / 2
      if (target == nums(mid)) return mid
      else if (nums(mid) < nums(high)) {
        if (target > nums(mid) && target <= nums(high)) low = mid + 1
        else high = mid - 1
      } else {
        if (target < nums(mid) && target >= nums(low)) high = mid - 1
        else low = mid + 1
      }
    }
    -1
  }
}
