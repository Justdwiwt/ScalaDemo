package leetCode

object Solution_416 {
  def canPartition(nums: Array[Int]): Boolean = {
    val s = nums.sum
    if ((s & 1) == 1) return false
    val m = s / 2 + 1
    val dp = Array.fill[Boolean](m)(false)
    dp(0) = true
    nums.foreach(num => (1 until m).reverse.foreach(i => if (num <= i) dp(i) = dp(i) || dp(i - num)))
    dp(m - 1)
  }
}
