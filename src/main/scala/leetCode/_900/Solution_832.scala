package leetCode._900

object Solution_832 {
  def flipAndInvertImage(A: Array[Array[Int]]): Array[Array[Int]] =
    A.map(_.reverse.map(_ ^ 1))
}
