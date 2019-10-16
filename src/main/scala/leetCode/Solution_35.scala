package leetCode

object Solution_35 {
  def searchInsert(nums: Array[Int], target: Int): Int = {
    for (i <- nums.indices)
      if (nums(i) >= target) return i
    nums.length
  }
}
