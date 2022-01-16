package leetCode

object Solution_2133 {
  def checkValid(matrix: Array[Array[Int]]): Boolean =
    (matrix ++ matrix.transpose).forall(_.toSet.size == matrix.length)
}
