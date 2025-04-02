package leetCode._3500

object Solution_3496 {
  def maxScore(nums: Array[Int]): Int = {
    val s = BigInt(nums.sum)
    if (nums.length % 2 == 1) (s - nums.min).toInt
    else nums.sliding(2).map { case Array(x, y) => s - x - y }.max.toInt
  }
}
