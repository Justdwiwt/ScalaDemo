package leetCode._3600

object Solution_3537 {
  def fillGrid(n: Int, startNumber: Int, topRightRow: Int, topRightCol: Int, grid: Array[Array[Int]]): Unit = {
    if (n == 1) grid(topRightRow)(topRightCol) = startNumber
    else Seq((0, 0), (n / 2, 0), (n / 2, -n / 2), (0, -n / 2))
      .zipWithIndex
      .foreach { case ((r, c), i) => fillGrid(n / 2, startNumber + n * n / 4 * i, topRightRow + r, topRightCol + c, grid) }

  }

  def specialGrid(n: Int): Array[Array[Int]] = {
    val d = BigInt(2).pow(n).toInt;
    val grid = Array.ofDim[Int](d, d)
    fillGrid(d, 0, 0, d - 1, grid)
    grid
  }
}
