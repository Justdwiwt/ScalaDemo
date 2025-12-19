package leetCode._3700

object Solution_3643 {
  def reverseSubmatrix(grid: Array[Array[Int]], x: Int, y: Int, k: Int): Array[Array[Int]] = {
    val pairs = (x to x + k / 2)
      .zip(x + k - 1 to x + k / 2 by -1)
      .toList

    val replaced = pairs.foldLeft(grid.map(_.clone())) { case (g, (i, j)) =>
      val rowI = g(i)
      val rowJ = g(j)

      val segI = rowI.slice(y, y + k)
      val segJ = rowJ.slice(y, y + k)

      g
        .updated(i, rowI.take(y) ++ segJ ++ rowI.drop(y + k))
        .updated(j, rowJ.take(y) ++ segI ++ rowJ.drop(y + k))
    }

    replaced
  }
}
