package leetCode._1500

object Solution_1492 {
  def kthFactor(n: Int, k: Int): Int = (1 to n)
    .filter(n % _ == 0)
    .lift(k - 1)
    .getOrElse(-1)
}
