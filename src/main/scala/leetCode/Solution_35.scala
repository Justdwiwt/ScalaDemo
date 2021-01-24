package leetCode

object Solution_35 {
  def searchInsert(nums: Array[Int], target: Int): Int =
    if (nums.contains(target)) nums.indexOf(target) else nums.length - nums.dropWhile(target >= _).length
}
