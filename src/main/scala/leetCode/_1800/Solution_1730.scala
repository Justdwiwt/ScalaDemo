package leetCode._1800

import scala.collection.mutable

object Solution_1730 {
  def getFood(grid: Array[Array[Char]]): Int = {
    val (m, n) = (grid.length, grid.head.length)
    var start: Option[(Int, Int)] = None

    grid.indices.foreach(i => grid.head.indices.withFilter(grid(i)(_) == '*').foreach(j => start = Some((i, j))))

    val queue = mutable.Queue(start.get)
    val visited = mutable.Set(start.get)
    var steps = 0
    var foundFood = false

    val directions = List((-1, 0), (1, 0), (0, 1), (0, -1))

    while (queue.nonEmpty && !foundFood) {
      queue.indices.foreach(_ => {
        val (i, j) = queue.dequeue()

        directions.foreach { case (di, dj) =>
          val (newI, newJ) = (i + di, j + dj)

          if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && !visited.contains((newI, newJ))) {
            grid(newI)(newJ) match {
              case '#' => foundFood = true
              case 'O' =>
                queue.enqueue((newI, newJ))
                visited.add((newI, newJ))
              case _ =>
            }
          }
        }
      })
      steps += 1
    }

    if (foundFood) steps else -1
  }
}
