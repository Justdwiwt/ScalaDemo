package leetCode._100

object Solution_48 {
  def rotate(matrix: Array[Array[Int]]): Unit =
    matrix.transpose.map(_.reverse).copyToArray(matrix)
}
