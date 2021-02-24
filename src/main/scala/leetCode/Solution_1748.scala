package leetCode

object Solution_1748 {
  def sumOfUnique(nums: Array[Int]): Int = nums
    .groupBy(i => i)
    .filter(_._2.length == 1)
    .keys
    .sum
}
