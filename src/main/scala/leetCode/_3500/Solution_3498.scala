package leetCode._3500

object Solution_3498 {
  def reverseDegree(s: String): Int = s
    .zipWithIndex
    .map { case (c, i) => (26 - (c - 'a')) * (i + 1) }
    .sum
}
