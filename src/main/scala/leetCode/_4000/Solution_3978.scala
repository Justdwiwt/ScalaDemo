package leetCode._4000

object Solution_3978 {
  def isMiddleElementUnique(nums: Array[Int]): Boolean =
    nums.count(_ == nums(nums.length / 2)) == 1
}
