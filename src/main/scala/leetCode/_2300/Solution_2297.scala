package leetCode._2300

import scala.collection.mutable

object Solution_2297 {
  def minCost(nums: Array[Int], costs: Array[Int]): Long = {
    val n = nums.length
    val dp = Array.fill[Long](n)(Long.MaxValue)
    dp(0) = 0

    val maxStack = mutable.Stack[Int]()
    val minStack = mutable.Stack[Int]()

    nums.indices.foreach(j => {
      while (minStack.nonEmpty && nums(minStack.top) <= nums(j)) {
        val i = minStack.pop()
        dp(j) = dp(j).min(dp(i) + costs(j))
      }
      minStack.push(j)

      while (maxStack.nonEmpty && nums(maxStack.top) > nums(j)) {
        dp(j) = dp(j).min(dp(maxStack.pop()) + costs(j))
      }
      maxStack.push(j)
    })

    dp(n - 1)
  }
}
