package leetCode._1800

object Solution_1738 {
  def kthLargestValue(matrix: Array[Array[Int]], k: Int): Int = {
    val dp = Array.fill(matrix.length + 1, matrix.head.length + 1)(0)

    val values = (1 to matrix.length).flatMap(i => (1 to matrix.head.length).map(j => {
      dp(i)(j) = dp(i - 1)(j) ^ dp(i)(j - 1) ^ dp(i - 1)(j - 1) ^ matrix(i - 1)(j - 1)
      dp(i)(j)
    }))

    values.sorted(Ordering[Int].reverse).apply(k - 1)
  }
}
