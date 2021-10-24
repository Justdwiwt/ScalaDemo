package leetCode

object Offer_076 {
  def findKthLargest(nums: Array[Int], k: Int): Int = nums
    .sorted
    .apply(nums.length - k)
}
