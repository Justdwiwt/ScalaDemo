package leetCode._300

object Solution_215 {
  def findKthLargest(nums: Array[Int], k: Int): Int = {
    nums.sorted.apply(nums.length - k)
  }
}
