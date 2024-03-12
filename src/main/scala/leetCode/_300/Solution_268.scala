package leetCode._300

object Solution_268 {
  def missingNumber(nums: Array[Int]): Int =
    (nums ++ (0 to nums.length)).reduce(_ ^ _)
}
