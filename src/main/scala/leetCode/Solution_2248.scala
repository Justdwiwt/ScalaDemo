package leetCode

object Solution_2248 {
  def intersection(nums: Array[Array[Int]]): List[Int] = nums
    .reduce(_.intersect(_))
    .sorted
    .toList
}
