package leetCode._2600

object Solution_2592 {
  def maximizeGreatness(nums: Array[Int]): Int =
    nums.length - nums.groupBy(identity).mapValues(_.length).values.max
}
