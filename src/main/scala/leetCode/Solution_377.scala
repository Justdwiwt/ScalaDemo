package leetCode

object Solution_377 {
  def combinationSum4(nums: Array[Int], target: Int): Int = {
    val dp = Array.fill(target + 1)(0)
    dp(0) = 1
    (1 to target).foreach(i => nums.foreach(a => if (i >= a) dp(1) += dp(i - a)))
    dp.last
  }
}
