package leetCode._2500

object Solution_2464 {
  val INF: Int = 1000000000

  def validSubarraySplit(nums: Array[Int]): Int = {
    val n: Int = nums.length
    val dp: Array[Int] = Array.fill(n + 1)(INF)
    dp(0) = 0

    @scala.annotation.tailrec
    def gcd(a: Int, b: Int): Int =
      if (b == 0) a else gcd(b, a % b)

    (1 to n).foreach(i => (1 to i).foreach(j => if (gcd(nums(i - 1), nums(j - 1)) > 1) dp(i) = dp(i).min(dp(j - 1) + 1)))

    if (dp(n) == INF) -1 else dp(n)
  }
}
