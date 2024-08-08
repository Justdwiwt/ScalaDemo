package leetCode._3300

object Solution_3239 {
  def minFlips(grid: Array[Array[Int]]): Int = {
    val m = grid.length / 2
    val n = grid.head.length / 2

    def rowFlips(row: Array[Int]): Int =
      (0 until n).count(i => row(i) != row(row.length - 1 - i))

    def colFlips(col: Array[Int]): Int =
      (0 until m).count(i => col(i) != col(col.length - 1 - i))

    val rowFlipSum = grid.map(rowFlips).sum
    val colFlipSum = grid.transpose.map(colFlips).sum
    rowFlipSum.min(colFlipSum)
  }
}
