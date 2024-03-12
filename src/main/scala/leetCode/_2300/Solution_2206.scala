package leetCode._2300

object Solution_2206 {
  def divideArray(nums: Array[Int]): Boolean = nums
    .groupBy(x => x)
    .map(_._2.length)
    .count(_ % 2 != 0) == 0
}
