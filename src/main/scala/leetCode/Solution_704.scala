package leetCode

object Solution_704 {
  def search(nums: Array[Int], target: Int): Int = {
    var left = 0
    var right = nums.length - 1
    while (left <= right) {
      val mid = (right + left) / 2
      if (nums(mid) == target) return mid
      else if (nums(mid) > target) right = mid - 1
      else left = mid + 1
    }
    -1
  }
}
