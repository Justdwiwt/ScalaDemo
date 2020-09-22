package leetCode

import scala.collection.mutable

object Solution_1091 {
  val diff = List(
    1 -> 0,
    -1 -> 0,
    0 -> 1,
    0 -> -1,
    -1 -> -1,
    1 -> -1,
    1 -> 1,
    -1 -> 1
  )

  def shortestPathBinaryMatrix(grid: Array[Array[Int]]): Int = {
    if (grid.isEmpty || grid(0).isEmpty || grid(0)(0) == 1 || grid(grid.length - 1)(grid(0).length - 1) == 1) return -1
    if (grid.length == 1 && grid(0).length == 1) return 1
    val q = mutable.Queue(0 -> 0)
    grid(0)(0) = 2
    var depth = 0
    var foundEnd = false
    while (!foundEnd && q.nonEmpty) {
      var size = q.size
      while (!foundEnd && size > 0) {
        size -= 1
        val curr = q.dequeue
        foundEnd = add(curr, q, grid)
      }
      depth += 1
    }

    if (foundEnd) depth + 1 else -1
  }

  def add(curr: (Int, Int), q: mutable.Queue[(Int, Int)], grid: Array[Array[Int]]): Boolean = {
    val ROW = grid.length - 1
    val COL = grid(0).length - 1
    diff.foreach({ case (rDiff, cDiff) =>
      val (row, col) = curr
      val nrow = row + rDiff
      val ncol = col + cDiff
      if (0 <= nrow && nrow <= ROW && 0 <= ncol && ncol <= COL && grid(nrow)(ncol) == 0) {
        if (nrow == ROW && ncol == COL) return true
        grid(nrow)(ncol) = 2
        q += nrow -> ncol
      }
    })
    false
  }
}
