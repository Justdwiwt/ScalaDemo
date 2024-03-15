package leetCode._2700

import scala.collection.mutable

object Solution_2617 {
  def minimumVisitedCells(grid: Array[Array[Int]]): Int = {
    val (m, n) = (grid.length, grid.head.length)
    val rows = Array.tabulate(m)(_ => mutable.TreeSet(0 until n: _*))
    val cols = Array.tabulate(n)(_ => mutable.TreeSet(0 until m: _*))

    val toVisit = mutable.Queue((0, 0, 1))
    while (toVisit.nonEmpty) {
      val (i, j, steps) = toVisit.dequeue()
      if (i == m - 1 && j == n - 1) return steps

      val reachable1 = rows(i).range(j + 1, (grid(i)(j) + j + 1).min(n))
      val reachable2 = cols(j).range(i + 1, (grid(i)(j) + i + 1).min(m))
      reachable1.map((i, _, steps + 1)).foreach(toVisit.+=)
      reachable2.map((_, j, steps + 1)).foreach(toVisit.+=)
      reachable1.foreach(rows(i).remove)
      reachable2.foreach(cols(j).remove)
    }

    -1
  }
}
