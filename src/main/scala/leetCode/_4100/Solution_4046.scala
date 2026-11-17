package leetCode._4100

import scala.collection.mutable

object Solution_4046 {
  def minCost(grid: Array[Array[Int]], k: Int): Int = {
    val dirs = Array((0, -1), (0, 1), (-1, 0), (1, 0))
    val m = grid.length
    val n = grid.head.length

    val dis = Array.fill(k + 1, m, n, 4)(Int.MaxValue)

    implicit val ord: Ordering[(Int, Int, Int, Int, Int)] =
      Ordering.by(-_._1)

    val pq = mutable.PriorityQueue.empty[(Int, Int, Int, Int, Int)]

    dis(k)(0)(0)(1) = grid(0)(0)
    dis(k)(0)(0)(3) = grid(0)(0)

    pq.enqueue((grid(0)(0), k, 0, 0, 1), (grid(0)(0), k, 0, 0, 3))

    while (pq.nonEmpty) {
      val (d, rem, i, j, idx) = pq.dequeue()

      if (i == m - 1 && j == n - 1) return d

      if (d <= dis(rem)(i)(j)(idx)) {
        dirs.indices.foreach { newIdx =>
          val (dx, dy) = dirs(newIdx)
          val x = i + dx
          val y = j + dy
          val newRem = rem - (if (newIdx == idx) 0 else 1)

          if (x >= 0 && x < m && y >= 0 && y < n && newRem >= 0) {
            val newD = d + grid(x)(y)

            if (newD < dis(newRem)(x)(y)(newIdx)) {
              dis(newRem)(x)(y)(newIdx) = newD
              pq.enqueue((newD, newRem, x, y, newIdx))
            }
          }
        }
      }
    }

    -1
  }
}
