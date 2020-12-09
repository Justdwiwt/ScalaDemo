package leetCode

object Solution_54 {
  def spiralOrder(matrix: Array[Array[Int]]): List[Int] = {
    def f(xs: List[List[Int]]): List[Int] = xs match {
      case Nil => Nil
      case x :: xs => x ++ f(xs.transpose.reverse)
    }

    f(matrix.toList.map(_.toList))
  }
}
