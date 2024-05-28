package leetCode._2200

import scala.collection.mutable

object Solution_2123 {
  private val dirs = Array((1, 0), (-1, 0), (0, 1), (0, -1))
  private var grid: Array[Array[Int]] = _
  private var m: Int = _
  private var n: Int = _
  private var st: mutable.Set[Int] = _
  private var link: Array[Int] = _

  def minimumOperations(grid: Array[Array[Int]]): Int = {
    this.grid = grid
    m = grid.length
    n = grid.head.length
    st = mutable.Set.empty[Int]
    link = new Array[Int](m * n)
    var cnt = 0
    grid.indices.foreach(i => grid.head.indices
      .withFilter(j => (i + j) % 2 != 0 && grid(i)(j) != 0)
      .withFilter(j => dfs(i * n + j))
      .foreach(_ => cnt += 1))
    cnt
  }

  private def dfs(k: Int): Boolean = {
    val i = k / n
    val j = k % n
    var found = false
    dirs
      .map { case (dx, dy) => val x = i + dx; ((dx, dy), x) }
      .map { case ((dx, dy), x) => val y = j + dy; ((dx, dy), x, y) }
      .withFilter { case ((_, _), x, y) => x >= 0 && x < m && y >= 0 && y < n && grid(x)(y) != 0 }
      .withFilter { case ((_, _), _, _) => !found }
      .foreach { case ((_, _), x, y) =>
        val z = x * n + y
        if (!st.contains(z)) {
          st += z
          if (link(z) == 0 || dfs(link(z))) {
            link(z) = k
            st -= z
            found = true
          }
          st -= z
        }
      }
    found
  }
}
