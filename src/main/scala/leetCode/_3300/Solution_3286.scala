package leetCode._3300

import scala.collection.immutable.Queue

object Solution_3286 {
  def findSafeWalk(grid: List[List[Int]], health: Int): Boolean = {
    val m = grid.length
    val n = grid.head.length
    val INF = Int.MaxValue
    val dis = Array.fill(m, n)(INF)
    dis(0)(0) = grid.head.head

    @scala.annotation.tailrec
    def bfs(queue: Queue[(Int, Int)]): Unit =
      if (queue.nonEmpty) {
        val ((i, j), rest) = queue.dequeue
        val neighbors = List((i, j + 1), (i, j - 1), (i + 1, j), (i - 1, j))
        val newQueue = neighbors.foldLeft(rest) { case (q, (x, y)) =>
          if (x >= 0 && x < m && y >= 0 && y < n) {
            val g = grid(x)(y)
            if (dis(i)(j) + g < dis(x)(y)) {
              dis(x)(y) = dis(i)(j) + g
              if (g == 0) (x, y) +: q
              else q :+ (x, y)
            } else q
          } else q
        }
        bfs(newQueue)
      }

    bfs(Queue((0, 0)))
    dis(m - 1)(n - 1) < health
  }
}
