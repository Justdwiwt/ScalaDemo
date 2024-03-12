package leetCode._1600

object Solution_1512 {
  def numIdenticalPairs(nums: Array[Int]): Int = nums
    .groupBy(identity)
    .mapValues(_.length)
    .map(t => (t._2 * (t._2 - 1)) / 2)
    .sum
}
