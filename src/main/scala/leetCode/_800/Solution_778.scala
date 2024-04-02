package leetCode._800

object Solution_778 {
  def swimInWater(grid: Array[Array[Int]]): Int = {
    val m = grid.length
    val n = grid.headOption.map(_.length).getOrElse(0)

    @scala.annotation.tailrec
    def comp(time: Int)(newlyReachable: Set[(Int, Int)], reachable: Set[(Int, Int)] = Set()): Set[(Int, Int)] = {
      val squares = newlyReachable.flatMap {
        case (row, col) if grid(row)(col) <= time =>
          Iterable((row + 1, col), (row - 1, col), (row, col + 1), (row, col - 1)).filter { case (i, j) =>
            grid.isDefinedAt(i) && grid(i).isDefinedAt(j) && grid(i)(j) <= time && !reachable.contains(i, j) && !newlyReachable.contains(i, j)
          }
        case _ => None
      }

      if (squares.isEmpty) reachable | newlyReachable
      else comp(time)(squares, reachable | newlyReachable)
    }

    def next(time: Int, reachable: Set[(Int, Int)]): (Int, Set[(Int, Int)]) = {
      val next = (time + 1, comp(time + 1)(reachable))
      next
    }

    Stream
      .from(0)
      .map(time => next(time - 1, Set((0, 0))))
      .find(_._2.contains(m - 1, n - 1))
      .map(_._1)
      .get
  }
}
