package leetCode._1200

object Solution_1121 {
  def canDivideIntoSubsequences(nums: Array[Int], K: Int): Boolean = {
    val hash = nums.groupBy(identity).mapValues(_.length)
    val maxCount = hash.values.reduceOption(_.max(_)).getOrElse(0)
    maxCount * K <= nums.length
  }
}
