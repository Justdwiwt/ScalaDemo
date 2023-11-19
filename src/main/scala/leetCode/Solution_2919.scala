package leetCode

object Solution_2919 {
  def minIncrementOperations(nums: Array[Int], k: Int): Long = {
    val dp = Array.fill(nums.length)(0L)
    dp(0) = (k - nums.head).max(0)
    nums.indices.drop(1).foreach(i => dp(i) = List(i - 3, i - 2, i - 1).map(n => if (n < 0) 0 else dp(n)).min + (k - nums(i)).max(0))
    List(nums.length - 1, nums.length - 2, nums.length - 3).map(dp(_)).min
  }
}
