package leetCode

object Solution_494 {
  def findTargetSumWays(nums: Array[Int], S: Int): Int = {
    var sum = 0
    var target = S
    nums.foreach(i => sum += i)
    if (sum < target || (sum + target) % 2 == 1) return 0
    target = (target + sum) / 2
    val dp = new Array[Int](target + 1)
    dp(0) = 1
    nums.foreach(i => (target to i by (-1)).foreach(j => dp(j) += dp(j - i)))
    dp(target)
  }
}
