package leetCode._1200

object Solution_1133 {
  def largestUniqueNumber(nums: Array[Int]): Int = nums
    .groupBy(identity)
    .collect { case (num, occurrences) if occurrences.length == 1 => num }
    .reduceOption(_.max(_))
    .getOrElse(-1)
}
