package leetCode._1100

object Solution_1006 {
  def clumsy(n: Int): Int = (n to 1 by -1)
    .view
    .sliding(2, 4)
    .map(_.product)
    .zip(Iterator(1) ++ Iterator.continually(-1))
    .map { case (x, y) => x * y }
    .zip((n - 2 to 1 by -4).iterator ++ Some(1))
    .map { case (x, y) => x / y }
    .++(n - 3 to 1 by -4)
    .sum
}
