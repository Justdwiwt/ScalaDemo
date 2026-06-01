package leetCode._3900

object Solution_3898 {
  def findDegrees(matrix: Array[Array[Int]]): Array[Int] =
    matrix.map(_.sum)
}
