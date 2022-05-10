package leetCode

object Solution_2267 {
  case class Point(y: Int, x: Int, sum: Int)

  def hasValidPath(grid: Array[Array[Char]]): Boolean = {

    def addition(y: Int, x: Int): Int =
      if (grid(y)(x) == '(') 1
      else -1

    var state = List(Point(grid.length - 1, grid.head.length - 1, addition(grid.length - 1, grid.head.length - 1)))

    while (state.nonEmpty) {
      state = state
        .filter(_.sum <= 0)
        .flatMap { case Point(y, x, s) =>
          val up = if (y > 0) Some(Point(y - 1, x, s + addition(y - 1, x))) else None
          val left = if (x > 0) Some(Point(y, x - 1, s + addition(y, x - 1))) else None
          up ++ left
        }
        .distinct

      if (state.contains(Point(0, 0, 0)))
        return true
    }

    false
  }
}
