package leetCode._300

object Solution_217 {
  def containsDuplicate(nums: Array[Int]): Boolean = nums.distinct.length != nums.length
}
