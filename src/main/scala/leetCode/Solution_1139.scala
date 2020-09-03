package leetCode

object Solution_1139 {
  def largest1BorderedSquare(grid: Array[Array[Int]]): Int = {
    def f(i: Int, j: Int, k: Int): Boolean = {
      (j until j + k).withFilter(x => grid(i)(x) == 0).foreach(_ => return false)
      (j until j + k).withFilter(x => grid(i + k - 1)(x) == 0).foreach(_ => return false)
      (i until i + k).withFilter(y => grid(y)(j) == 0).foreach(_ => return false)
      (i until i + k).withFilter(y => grid(y)(j + k - 1) == 0).foreach(_ => return false)
      true
    }

    (grid.length.min(grid(0).length) to 1).by(-1).foreach(k => grid.indices.foreach(i => grid(i).indices
      .map({ j => val x = i + k - 1; (j, x) })
      .map({ case (j, x) => val y = j + k - 1; (j, x, y) })
      .withFilter({ case (_, x, y) => x < grid.length && y < grid(0).length })
      .foreach({ case (j, _, _) => if (f(i, j, k)) return k * k })))
    0
  }
}
