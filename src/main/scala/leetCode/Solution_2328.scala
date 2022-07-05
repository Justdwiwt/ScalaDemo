package leetCode

import scala.collection.mutable

object Solution_2328 {
  def countPaths(grid: Array[Array[Int]]): Int = {
    val M = 1000000007
    val m = mutable.Map.empty[(Int, Int), Long]

    def neighbours(x: Int, y: Int): Array[(Int, Int)] = Array((-1, 0), (0, -1), (0, 1), (1, 0))
      .map { case (dx, dy) => (x + dx, y + dy) }
      .filter { case (nx, ny) => nx.min(ny) >= 0 && nx < grid.length && ny < grid.head.length }

    def dfs(x: Int, y: Int): Long = m.getOrElseUpdate((x, y), 1 + neighbours(x, y)
      .collect { case (nx, ny) if grid(nx)(ny) < grid(x)(y) => dfs(nx, ny) }
      .sum % M
    )

    grid
      .indices
      .flatMap(x => grid.head.indices.map(y => dfs(x, y)))
      ./:(0L)((total, cnt) => (total + cnt) % M)
      .toInt

  }
}
