package leetCode

import scala.collection.mutable

object Solution_3040 {
  def maxOperations(nums: Array[Int]): Int = {
    val m = mutable.Map.empty[(Int, Int, Int), Int]

    def dfs(i: Int, j: Int, target: Int): Int = m
      .getOrElseUpdate((i, j, target),
        if (i >= j) 0
        else {
          val both = if (nums(i) + nums(j) == target) 1 + dfs(i + 1, j - 1, target) else 0
          val left = if (nums(i) + nums(i + 1) == target) 1 + dfs(i + 2, j, target) else 0
          val right = if (nums(j - 1) + nums(j) == target) 1 + dfs(i, j - 2, target) else 0
          both.max(left).max(right)
        }
      )

    val both = dfs(i = 1, j = nums.length - 2, target = nums.head + nums.last)
    val left = dfs(i = 2, j = nums.length - 1, target = nums.take(2).sum)
    val right = dfs(i = 0, j = nums.length - 3, target = nums.takeRight(2).sum)
    1 + both.max(left).max(right)
  }
}
