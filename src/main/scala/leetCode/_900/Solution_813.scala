package leetCode._900

import scala.collection.mutable

object Solution_813 {
  def largestSumOfAverages(nums: Array[Int], k: Int): Double = {
    val m = mutable.Map.empty[(Int, Int, Int), Double]

    def avg(start: Int, end: Int): Double =
      nums.slice(start, end).sum.toDouble / (end - start)

    def dfs(pre: Int, cur: Int, budget: Int): Double = m.getOrElseUpdate((pre, cur, budget), {
      if (cur == nums.length) 0
      else if (budget == 1) avg(cur, nums.length)
      else (avg(pre, cur + 1) + dfs(cur + 1, cur + 1, budget - 1)).max(dfs(pre, cur + 1, budget))
    })

    dfs(pre = 0, cur = 0, budget = k)
  }
}
