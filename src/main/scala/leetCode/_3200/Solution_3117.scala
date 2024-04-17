package leetCode._3200

import scala.collection.mutable

object Solution_3117 {
  // fixme: case 499/509 stack overflow
  def minimumValueSum(nums: Array[Int], andValues: Array[Int]): Int = {
    val memo = mutable.Map.empty[Long, Int]
    val res = dfs(0, 0, -1, nums, andValues, memo)
    if (res < Int.MaxValue / 2) res else -1
  }

  private def dfs(i: Int, j: Int, andVal: Int, nums: Array[Int], andValues: Array[Int], memo: mutable.Map[Long, Int]): Int = {
    val n = nums.length
    val m = andValues.length
    if (m - j > n - i) return Int.MaxValue / 2
    if (j == m) return if (i == n) 0 else Int.MaxValue / 2
    val andResult = if (andVal == -1) nums(i) else andVal & nums(i)
    if (andResult < andValues(j)) return Int.MaxValue / 2
    val mask: Long = (i.toLong << 36) | (j.toLong << 32) | andResult.toLong
    if (memo.contains(mask)) return memo(mask)
    var res = dfs(i + 1, j, andResult, nums, andValues, memo)
    if (andResult == andValues(j)) {
      res = res.min(dfs(i + 1, j + 1, -1, nums, andValues, memo) + nums(i))
    }
    memo(mask) = res
    res
  }
}
