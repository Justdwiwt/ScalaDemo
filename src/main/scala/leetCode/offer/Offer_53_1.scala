package leetCode.offer

object Offer_53_1 {
  def search(nums: Array[Int], target: Int): Int = binarySearch(nums, target + 0.5) - binarySearch(nums, target - 0.5)

  def binarySearch(nums: Array[Int], target: Double): Int = {
    var left = 0
    var right = nums.length - 1
    while (left <= right) {
      val mid = (right + left) >>> 1
      if (nums(mid) < target) left = mid + 1
      else if (nums(mid) > target) right = mid - 1
    }
    left
  }
}
