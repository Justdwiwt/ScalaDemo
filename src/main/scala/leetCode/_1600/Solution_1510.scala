package leetCode._1600

import scala.collection.mutable

object Solution_1510 {
  def winnerSquareGame(n: Int): Boolean = {
    val mem = mutable.Map.empty[Int, Boolean]

    def dfs(n: Int): Boolean = mem.getOrElseUpdate(n, n > 0 && Iterator
      .iterate(math.sqrt(n).toInt)(_ - 1)
      .takeWhile(_ > 0)
      .exists(v => !dfs(n - v * v)))

    dfs(n)
  }
}
