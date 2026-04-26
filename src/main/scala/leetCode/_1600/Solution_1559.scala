package leetCode._1600

object Solution_1559 {
  def containsCycle(grid: Array[Array[Char]]): Boolean = {
    def validXY(a: Int)(b: Int): Boolean = !(a < 0 || a >= grid.length || b < 0 || b >= grid.head.length)

    val visited = grid.indices.map(i => grid.head.indices.map(j => false).toArray).toArray

    def impl(i: Int, j: Int, i0: Int, j0: Int, ch: Char): Boolean =
      if (!validXY(i)(j) || grid(i)(j) != ch) false else {
        visited(i)(j) = true

        List((-1, 0), (1, 0), (0, -1), (0, +1))
          .map { case (x: Int, y: Int) => (i + x) -> (j + y) }
          .filterNot { case (a, b) => (a == i0 && b == j0) || !validXY(a)(b) || grid(a)(b) != ch }
          .exists { case (a, b) => visited(a)(b) || impl(a, b, i, j, ch) }
      }

    grid.indices.exists(i => grid.head.indices.exists(j => !visited(i)(j) && impl(i, j, -1, -1, grid(i)(j))))
  }
}
