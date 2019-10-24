package leetCode

object Solution_35 {
  def searchInsert(nums: Array[Int], target: Int): Int = {
    nums.indices.foreach(i => if (nums(i) >= target) return i)
    nums.length
  }
}
