package leetCode

object Solution_2133 {
  def checkValid(matrix: Array[Array[Int]]): Boolean = {
    def f(m: Array[Array[Int]]): Boolean =
      m.forall(x => x.distinct.length == x.length && x.min == 1 && x.max == x.length)

    f(matrix) && f(matrix.transpose)
  }
}
