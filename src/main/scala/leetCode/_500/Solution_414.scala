package leetCode._500

object Solution_414 {
  def thirdMax(nums: Array[Int]): Int =
    if (nums.distinct.length < 3) nums.max
    else nums.distinct.sorted.takeRight(3).head
}
