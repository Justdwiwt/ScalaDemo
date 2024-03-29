package leetCode._1200

import scala.collection.mutable

object Solution_1140 {
  def stoneGameII(piles: Array[Int]): Int = {
    val sum = piles.scanRight(0)(_ + _).dropRight(1)

    val map = mutable.Map.empty[(Int, Int), Int]

    def dfs(i: Int, m: Int): Int = {
      if (!map.contains((i, m))) {
        map((i, m)) = if (i + 2 * m >= sum.length) sum(i)
        else (1 to 2 * m).map(j => sum(i) - dfs(i + j, j.max(m))).max
      }
      map((i, m))
    }

    dfs(0, 1)
  }
}
