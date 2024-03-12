package leetCode._3000

object Solution_2906 {
  def constructProductMatrix(grid: Array[Array[Int]]): Array[Array[Int]] = {
    val M = 12345
    val (m, n) = (grid.length, grid.head.length)

    val prefixProduct = grid.flatten.scanLeft(1L)((acc, v) => (acc * v) % M)
    val suffixProduct = grid.flatten.scanRight(1L)((v, acc) => (acc * v) % M).tail

    Array.tabulate(m)(r => Array.tabulate(n)(c => (prefixProduct(r * n + c) * suffixProduct(r * n + c) % M).toInt))
  }
}
