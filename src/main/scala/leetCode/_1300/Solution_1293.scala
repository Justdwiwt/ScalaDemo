package leetCode._1300

import scala.collection.mutable

object Solution_1293 {
  def shortestPath(grid: Array[Array[Int]], k: Int): Int = {
    val m = grid.length
    val n = grid.head.length
    val q = mutable.PriorityQueue((0 -> 0, k, 0))(Ordering.by(t => (-t._3, -t._2)))
    val seen = Array.fill(m)(Array.fill(n)(Array(0, Int.MaxValue)))
    while (q.nonEmpty) {
      val ((y, x), blockRemovers, steps) = q.dequeue
      if (y == m - 1 && x == n - 1) return steps
      if ((seen(y)(x).head < blockRemovers || seen(y)(x)(1) > steps) && (blockRemovers > 0 || grid(y)(x) == 0)) {
        seen(y)(x)(0) = seen(y)(x).head.max(blockRemovers)
        seen(y)(x)(1) = seen(y)(x)(1).min(steps)
        val remainingBlockRemovers = blockRemovers - (if (grid(y)(x) == 0) 0 else 1)
        val nextCells = Seq((-1, 0), (0, 1), (1, 0), (0, -1))
          .map { case (dy, dx) => (dy + y, dx + x) }
          .filter { case (ny, nx) => nx >= 0 && ny >= 0 && ny < m && nx < n && (seen(ny)(nx).head < remainingBlockRemovers || seen(ny)(nx)(1) > steps + 1) }

        nextCells.foreach(next => q += ((next, remainingBlockRemovers, steps + 1)))
      }
    }
    -1
  }
}
