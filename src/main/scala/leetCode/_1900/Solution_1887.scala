package leetCode._1900

object Solution_1887 {
  def reductionOperations(nums: Array[Int]): Int = nums
    .filter(_ != nums.min)
    .groupBy(identity)
    .mapValues(_.length)
    .toList
    .sortBy(-_._1)
    .map(_._2)
    .scanLeft(0)(_ + _)
    .sum
}
