package leetCode

import scala.collection.mutable

object Solution_778 {
  def swimInWater(grid: Array[Array[Int]]): Int = {
    val N = grid.length
    val diff = Array((-1, 0), (1, 0), (0, -1), (0, 1))
    val pq = new mutable.PriorityQueue[(Int, Int, Int)]()((x: (Int, Int, Int), y: (Int, Int, Int)) => y._3 - x._3)
    pq += ((0, 0, grid(0)(0)))
    val s = new mutable.HashSet[(Int, Int)]
    while (pq.nonEmpty) {
      val (x, y, weight) = pq.dequeue()
      if (x == N - 1 && y == N - 1) return weight
      if (!s.contains((x, y))) {
        s += ((x, y))
        diff.foreach({ case (sx, sy) =>
          val p0 = x + sx
          val p1 = y + sy
          val boarder = p0 < 0 || p0 >= N || p1 < 0 || p1 >= N
          if (!boarder && !s.contains((p0, p1))) {
            val t = 0.max(grid(p0)(p1) - weight.max(grid(x)(y)))
            pq += ((p0, p1, weight + t))
          }
        })
      }
    }
    throw new RuntimeException("can not be here")
  }
}
