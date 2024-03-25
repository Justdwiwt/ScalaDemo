package leetCode._1600

import scala.collection.mutable

object Solution_1584 {
  def minCostConnectPoints(_points: Array[Array[Int]]): Int = {
    val pq = mutable.PriorityQueue.empty[(Int, Int)]
    val visited = Array.ofDim[Boolean](_points.length)

    Iterator
      .iterate((0, 0, 1)) { case (totalCost, i, connected) =>
        visited(i) = true
        _points
          .indices
          .filter(!visited(_))
          .foreach(j => pq.enqueue((-distance(_points, i, j), j)))
        val (d, j) = Iterator
          .iterate((0, i))(_ => pq.dequeue())
          .dropWhile { case (_, j) => visited(j) }
          .next()
        (totalCost - d, j, connected + 1)
      }
      .dropWhile { case (_, _, connected) => connected < _points.length }
      .next()
      ._1
  }

  private def distance(points: Array[Array[Int]], i: Int, j: Int): Int = {
    val (Array(x0, y0), Array(x1, y1)) = (points(i), points(j))
    (x0 - x1).abs + (y0 - y1).abs
  }
}
