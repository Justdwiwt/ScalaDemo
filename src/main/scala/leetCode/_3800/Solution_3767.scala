package leetCode._3800

object Solution_3767 {
  def maxPoints(a: Array[Int], b: Array[Int], k: Int): Long = a
    .map(_.toLong)
    .sum + a
    .zip(b)
    .collect { case (x, y) if y > x => (y - x).toLong }
    .sorted(Ordering.Long.reverse)
    .take(a.length - k)
    .sum
}
