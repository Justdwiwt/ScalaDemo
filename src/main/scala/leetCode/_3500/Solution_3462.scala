package leetCode._3500

object Solution_3462 {
  def maxSum(grid: Array[Array[Int]], limits: Array[Int], k: Int): Long = grid
    .map(_.sorted.reverse)
    .zip(limits)
    .flatMap(n => n._1.take(n._2))
    .sorted
    .reverse
    .take(k)
    .map(_.toLong)
    .sum
}
