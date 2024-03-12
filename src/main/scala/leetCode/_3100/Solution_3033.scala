package leetCode._3100

object Solution_3033 {
  def modifiedMatrix(matrix: Array[Array[Int]]): Array[Array[Int]] = {
    val maxPerCol = matrix.transpose.map(_.max)
    Array.tabulate(matrix.length, matrix.head.length)((i, j) => if (matrix(i)(j) != -1) matrix(i)(j) else maxPerCol(j))
  }
}
