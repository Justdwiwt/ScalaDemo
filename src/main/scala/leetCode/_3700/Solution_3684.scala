package leetCode._3700

object Solution_3684 {
  def maxKDistinct(nums: Array[Int], k: Int): Array[Int] = nums
    .toSet
    .toArray
    .sortBy(-_)
    .take(k)
}
