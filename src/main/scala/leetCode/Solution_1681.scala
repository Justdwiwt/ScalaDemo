package leetCode

import scala.util.control.Breaks._

object Solution_1681 {
  def minimumIncompatibility(nums: Array[Int], k: Int): Int = {
    val n = 0
    val memo = Array.fill(1 << 16)(0)

    def dfs(nums: Array[Int], state: Int, seen: Int, pos: Int, N: Int, K: Int, min: Int, max: Int): Int = {
      if (N == 0) {
        return max - min + (if (memo(state) != 0) memo(state) else {
          memo(state) = if (k == 1) 0 else dfs(nums, state, 0, 0, n, K - 1, 1000, 0)
          memo(state)
        })
      }
      var res = 1000
      breakable((pos until nums.length).foreach(i => {
        if (N == n && nums.length - i < n * K) break()
        breakable(if ((state & (1 << i)) != 0 || (seen & (1 << nums(i))) != 0) break())
        res = math.min(dfs(nums, state | (1 << i), seen | (1 << nums(i)), i + 1, N - 1, K, math.min(min, nums(i)), math.max(max, nums(i))), res)
      }))
      res
    }

    val res = dfs(nums, 0, 0, 0, n, k, 1000, 0)
    if (res == 1000) -1 else res
  }
}
