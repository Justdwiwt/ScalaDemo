package leetCode._4000

object Solution_3976 {
  def maxSubarraySum(nums: Array[Int], k: Int): Long = {
    def solve(mul: Boolean): Long = {
      val (_, _, _, res) = nums.foldLeft((0L, 0L, 0L, Long.MinValue)) {
        case ((f0, f1, f2, res), x) =>
          val y = if (mul) x.toLong * k else x.toLong / k

          val n2 = f1.max(f2) + x
          val n1 = 0L.max(f0.max(f1)) + y
          val n0 = f0.max(0L) + x

          (n0, n1, n2, n2.max(res.max(n1)))
      }

      res
    }

    solve(true).max(solve(false))
  }
}
