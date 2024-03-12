package leetCode._2200

object Solution_2134 {
  def minSwaps(nums: Array[Int]): Int = {
    val arr = nums ++ nums
    val cnt = nums.count(_ == 1)
    val dp = Array.fill(arr.length)(0)
    dp.indices.foreach(i => dp(i) = arr(i) + dp.lift(i - 1).getOrElse(0))
    nums.indices.map(i => cnt - (dp(i + cnt) - dp(i))).min
  }
}
