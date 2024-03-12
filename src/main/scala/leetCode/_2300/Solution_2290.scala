package leetCode._2300

import scala.collection.mutable

object Solution_2290 {
  def minimumObstacles(grid: Array[Array[Int]]): Int = {
    val (m, n) = (grid.length - 1, grid.head.length - 1)
    val toVisit = mutable.PriorityQueue((0, 0, 0))
    val visited = mutable.Map((0, 0) -> 0)
    while (toVisit.nonEmpty) {
      val (steps, x, y) = toVisit.dequeue()
      if (x == m && y == n) return -steps
      neighbours(x, y, grid).foreach { case (nx, ny) =>
        val nextSteps = steps - grid(nx)(ny)
        if (nextSteps > visited.getOrElse((nx, ny), Int.MinValue)) {
          toVisit.enqueue((nextSteps, nx, ny))
          visited.update((nx, ny), nextSteps)
        }
      }
    }
    Int.MaxValue
  }

  def neighbours[T](x: Int, y: Int, grid: Array[Array[T]]): Seq[(Int, Int)] = Seq((-1, 0), (0, -1), (0, 1), (1, 0))
    .collect { case (dx, dy) if x + dx >= 0 && x + dx < grid.length && y + dy >= 0 && y + dy < grid.head.length =>
      (x + dx, y + dy)
    }
}
