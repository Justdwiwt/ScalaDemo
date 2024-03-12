package leetCode._800

object Solution_766 {
  def isToeplitzMatrix(matrix: Array[Array[Int]]): Boolean = matrix.zip(matrix.tail).forall(i => i._1.dropRight(1).toList == i._2.tail.toList)
}
