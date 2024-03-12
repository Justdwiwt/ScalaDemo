package leetCode._2300

object Solution_2239 {
  def findClosestNumber(nums: Array[Int]): Int =
    nums.minBy(num => (num.abs, -num))
}
