package leetCode._500

object Solution_416 {
  def canPartition(nums: Array[Int]): Boolean = {
    val sum = nums.sum
    if (sum % 2 != 0) false
    else {
      val sum2 = sum / 2
      val dp = Array.fill(sum2 + 1)(false)
      dp(0) = true
      nums
        .indices
        .map { i => val num = nums(i); (i, num) }
        .foreach { case (_, num) => (sum2 to num by -1).foreach(j => if (dp(j - num)) dp(j) = true) }
      dp(sum2)
    }
  }
}
