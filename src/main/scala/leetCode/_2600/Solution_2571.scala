package leetCode._2600

object Solution_2571 {
  def minOperations(n: Int): Int =
    Integer.bitCount(3 * n ^ n)
}
