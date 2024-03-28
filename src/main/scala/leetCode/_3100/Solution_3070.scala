package leetCode._3100

object Solution_3070 {
  def countSubmatrices(grid: Array[Array[Int]], k: Int): Int = grid
    .map(_.scanLeft(0)(_ + _).tail)
    .transpose
    .flatMap(_.scanLeft(0)(_ + _).tail)
    .count(_ <= k)
}
