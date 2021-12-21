package leetCode

import scala.collection.mutable

object Solution_2088 {
  def countPyramids(grid: Array[Array[Int]]): Int = {

    val m = mutable.Map.empty[(Int, Int, Int), Int]

    def dfs(x: Int, y: Int, dr: Int): Int = m.getOrElseUpdate((x, y, dr), {
      if (grid(x)(y) == 1 && 0 <= x + dr && x + dr < grid.length && y > 0 && y < grid.head.length - 1 && grid(x + dr)(y) == 1)
        1 + dfs(x + dr, y - 1, dr).min(dfs(x + dr, y + 1, dr))
      else grid(x)(y)
    })

    grid.indices.flatMap(x => grid.head.indices.map(y => 0.max(dfs(x, y, dr = 1) - 1) + 0.max(dfs(x, y, dr = -1) - 1))).sum
  }
}
