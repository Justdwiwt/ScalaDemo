package leetCode._2500

object Solution_2413 {
  def smallestEvenMultiple(n: Int): Int =
    n << (n & 1)
}
