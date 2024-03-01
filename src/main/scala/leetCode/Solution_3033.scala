package leetCode

object Solution_3033 {
  def modifiedMatrix(matrix: Array[Array[Int]]): Array[Array[Int]] = {
    matrix
      .head
      .indices
      .map { c => val col = matrix.map(_(c)); (c, col) }
      .map { case (c, col) => val colMax = col.max; (c, col, colMax) }
      .foreach { case (c, _, colMax) => matrix
        .indices
        .withFilter(r => matrix(r)(c) == -1)
        .foreach(r => matrix(r)(c) = colMax)
      }
    matrix
  }
}
