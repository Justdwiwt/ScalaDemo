package leetCode._3600

object Solution_3566 {
  def checkEqualPartitions(nums: Array[Int], target: Long): Boolean = {
    def dfs(i: Int, mul1: Long, mul2: Long): Boolean =
      if (i == nums.length) mul1 == target && mul2 == target
      else {
        val curr = nums(i).toLong
        dfs(i + 1, mul1 * curr, mul2) || dfs(i + 1, mul1, mul2 * curr)
      }

    dfs(0, 1L, 1L)
  }
}
