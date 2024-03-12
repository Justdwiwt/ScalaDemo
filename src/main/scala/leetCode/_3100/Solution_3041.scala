package leetCode._3100

object Solution_3041 {
  def maxSelectedElements(nums: Array[Int]): Int = nums
    .sorted
    ./:(Map.empty[Int, Int].withDefaultValue(0))((dp, n) => dp.updated(n + 1, dp(n) + 1).updated(n, dp(n - 1) + 1))
    .values
    .max
}
