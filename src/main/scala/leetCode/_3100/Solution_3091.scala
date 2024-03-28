package leetCode._3100

object Solution_3091 {
  def minOperations(k: Int): Int =
    math.sqrt(4 * k - 3).toInt - 1
}
