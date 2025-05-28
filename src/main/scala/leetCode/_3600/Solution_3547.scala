package leetCode._3600

object Solution_3547 {
  def maxScore(n: Int, edges: Array[Array[Int]]): Long = {
    val base = (2L * n * n + 5L * n - 6) * (n - 1) / 6
    val extra = if (edges.length == n) 2L else 0L
    base + extra
  }
}
