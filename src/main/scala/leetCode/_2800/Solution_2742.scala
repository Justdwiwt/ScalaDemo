package leetCode._2800

import scala.collection.mutable

object Solution_2742 {
  def paintWalls(cost: Array[Int], time: Array[Int]): Int = {
    val m = mutable.Map.empty[(Int, Int), Int]

    def dfs(i: Int, t: Int): Int = m.getOrElseUpdate((i, t),
      if (i == cost.length) if (t >= 0) 0 else 1e9.toInt
      else (cost(i) + dfs(i + 1, (t + time(i)).min(time.length))).min(dfs(i + 1, t - 1)))

    dfs(0, 0)
  }
}
