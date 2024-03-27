package leetCode._1400

import scala.collection.mutable

object Solution_1368 {
  private val diff = Map(
    (1, 0) -> 4,
    (-1, 0) -> 3,
    (0, -1) -> 1,
    (0, 1) -> 2
  )

  def minCost(grid: Array[Array[Int]]): Int = {
    val arr = Array.fill(grid.length, grid.head.length)(grid.length - 1 + grid.head.length - 1)
    arr(grid.length - 1)(grid.head.length - 1) = 0
    val pq = mutable.PriorityQueue[(Int, Int, Int)]()((x: (Int, Int, Int), y: (Int, Int, Int)) => y._3 - x._3)
    pq += ((grid.length - 1, grid(0).length - 1, 0))
    while (pq.nonEmpty) {
      val (x, y, cost) = pq.dequeue()
      if (arr(x)(y) >= cost)
        diff
          .keys
          .withFilter { case (dirX, dirY) => (x + dirX >= 0) && (x + dirX < grid.length) && (y + dirY >= 0) && (y + dirY < grid.head.length) }
          .foreach { case (dirX, dirY) =>
            val X = x + dirX
            val Y = y + dirY
            var cost = 1
            if (diff((dirX, dirY)) == grid(X)(Y)) cost = 0
            if (arr(X)(Y) > cost + arr(x)(y)) {
              arr(X)(Y) = cost + arr(x)(y)
              pq += ((X, Y, arr(X)(Y)))
            }
          }
    }
    arr.head.head
  }
}
