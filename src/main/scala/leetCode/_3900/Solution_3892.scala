package leetCode._3900

object Solution_3892 {
  def minOperations(nums: Array[Int], k: Int): Int = {
    val n = nums.length

    if (k > n / 2) return -1

    val peaks = nums.indices.count(i => nums((i - 1 + n) % n) < nums(i) && nums(i) > nums((i + 1) % n))

    if (peaks >= k) return 0

    def solve(arr: Array[Int]): Int = {
      val m = arr.length
      val inf = Int.MaxValue / 2

      val ops = (1 until m - 1)
        .map(i => 0.max(arr(i - 1).max(arr(i + 1)) - arr(i) + 1))
        .toArray

      val dp = Array.fill(m)(0)

      (1 to k).foreach(left => {
        var prev0 = dp(left * 2 - 2)
        var prev1 = dp(left * 2 - 1)

        dp(left * 2 - 1) = inf

        (left * 2 - 1 until m - 1 - (k - left) * 2).foreach(i => {
          val keep = dp(i)
          val take = prev0 + ops(i - 1)

          prev0 = prev1
          prev1 = dp(i + 1)

          dp(i + 1) = keep.min(take)
        })
      })

      dp.last
    }

    solve(Array(nums.last) ++ nums).min(solve(nums ++ Array(nums.head)))
  }
}
