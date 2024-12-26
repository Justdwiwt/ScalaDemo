package leetCode._3400

import scala.collection.mutable

object Solution_3393 {
  def countPathsWithXorValue(grid: Array[Array[Int]], k: Int): Int = {
    val M = 1000000007

    val cache = mutable.Map.empty[(Int, Int, Int), Int]

    def dfs(i: Int, j: Int, x: Int): Int =
      if (i < 0 || j < 0) 0
      else if (i == 0 && j == 0) {
        if (x == grid(i)(j)) 1 else 0
      } else {
        cache.getOrElseUpdate((i, j, x), {
          val valAtPos = grid(i)(j)
          (dfs(i, j - 1, x ^ valAtPos) + dfs(i - 1, j, x ^ valAtPos)) % M
        })
      }

    dfs(grid.length - 1, grid.head.length - 1, k)
  }
}
