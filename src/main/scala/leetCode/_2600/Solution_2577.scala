package leetCode._2600

import scala.collection.mutable

object Solution_2577 {
  private val dx = List(0, 0, 1, -1)
  private val dy = List(1, -1, 0, 0)
  private val INF: Int = 1000000000

  case class Node(distance: Int, x: Int, y: Int)

  implicit val ordering: Ordering[Node] = Ordering.by((node: Node) => -node.distance)

  private def dijkstra(grid: Array[Array[Int]], dist: Array[Array[Int]]): Array[Array[Int]] = {
    val queue = mutable.PriorityQueue(Node(0, 0, 0))

    @scala.annotation.tailrec
    def loop(queue: mutable.PriorityQueue[Node], dist: Array[Array[Int]]): Array[Array[Int]] = {
      if (queue.isEmpty) dist
      else {
        val Node(d, x, y) = queue.dequeue()

        val neighbors = dx
          .zip(dy)
          .map { case (dx, dy) => val nx = x + dx; ((dx, dy), nx) }
          .map { case ((dx, dy), nx) => val ny = y + dy; ((dx, dy), nx, ny) }
          .withFilter { case ((_, _), nx, ny) => nx >= 0 && nx < grid.length && ny >= 0 && ny < grid.head.length }
          .map { case ((_, _), nx, ny) =>
            var tmp = d + 1
            if (grid(nx)(ny) > tmp) tmp = ((grid(nx)(ny) - d - 1 + 1) / 2) * 2 + d + 1
            if (dist(nx)(ny) > tmp) {
              dist(nx)(ny) = tmp
              Some(Node(tmp, nx, ny))
            } else None
          }

        neighbors.flatten.foreach(queue.enqueue(_))

        loop(queue, dist)
      }
    }

    loop(queue, dist)
  }

  def minimumTime(grid: Array[Array[Int]]): Int = {
    if (grid.head(1) > 1 && grid(1).head > 1) return -1

    val m = grid.length
    val n = grid.head.length

    val dist = Array.fill(m, n)(INF)
    dist.head(0) = 0

    val finalDist = dijkstra(grid, dist)

    finalDist(m - 1)(n - 1)
  }
}
