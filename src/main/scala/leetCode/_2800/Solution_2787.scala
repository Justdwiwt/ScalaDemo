package leetCode._2800

import scala.collection.mutable

object Solution_2787 {
  def numberOfWays(n: Int, x: Int): Int = {
    val nums = Iterator.iterate(1)(_ + 1).map(math.pow(_, x).toInt).takeWhile(_ <= n).toArray

    val m = mutable.Map.empty[(Int, Int), Long]

    def dfs(i: Int, target: Int): Long = m.getOrElseUpdate((i, target),
      if (target == 0) 1
      else if (i == nums.length) 0
      else if (nums(i) > target) 0
      else (dfs(i + 1, target - nums(i)) + dfs(i + 1, target)) % 1000000007)

    dfs(i = 0, target = n).toInt
  }
}
