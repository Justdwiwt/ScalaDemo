package leetCode._2800

import scala.collection.mutable

object Solution_2741 {
  def specialPerm(nums: Array[Int]): Int = {
    val m = mutable.Map.empty[(Int, Int), Int]

    def dfs(i: Int, mask: Int): Int = m.getOrElseUpdate((i, mask),
      if (mask == (1 << nums.length) - 1) 1
      else nums.indices.foldLeft(0L)((acc, j) =>
        if ((mask & (1 << j)) != 0 || (mask != 0 && nums(i) % nums(j) != 0 && nums(j) % nums(i) != 0)) acc
        else (acc + dfs(j, mask | (1 << j))) % 1000000007).toInt)

    dfs(0, 0)
  }
}
