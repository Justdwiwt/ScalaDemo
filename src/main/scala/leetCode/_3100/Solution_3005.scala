package leetCode._3100

object Solution_3005 {
  def maxFrequencyElements(nums: Array[Int]): Int = {
    val t = nums.groupBy(identity).mapValues(_.length)
    val mx = t.values.max
    t.count(_._2 == mx) * mx
  }
}
