package leetCode._100

object Solution_74 {
  def searchMatrix(matrix: Array[Array[Int]], target: Int): Boolean =
    matrix.flatten.contains(target)
}
