package leetCode._2500

object Solution_2482 {
  def onesMinusZeros(grid: Array[Array[Int]]): Array[Array[Int]] = {
    val onesRows = grid.map(_.sum)
    val onesCols = grid.transpose.map(_.sum)
    val (m, n) = (onesRows.length, onesCols.length)
    Array.tabulate(m, n)(2 * onesRows(_) + 2 * onesCols(_) - m - n)
  }
}
