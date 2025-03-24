package leetCode._3500

object Solution_3487 {
  def maxSum(nums: Array[Int]): Int = {
    val uniqueNums = nums.toSet
    val maxVal = nums.max
    val positiveSum = uniqueNums.filter(_ > 0).sum

    if (positiveSum > 0) positiveSum else maxVal
  }
}
