package leetCode

object Solution_1738 {
  def kthLargestValue(matrix: Array[Array[Int]], k: Int): Int = {
    val dp = Array.ofDim[Int](matrix.length + 1, matrix.head.length + 1)
    val pq = new java.util.PriorityQueue[Int]
    (1 to matrix.length).foreach(i => (1 to matrix.head.length).foreach(f = j => {
      dp(i)(j) = dp(i - 1)(j) ^ dp(i)(j - 1) ^ dp(i - 1)(j - 1) ^ matrix(i - 1)(j - 1)
      pq.offer(dp(i)(j))
      while (pq.size() > k) pq.poll()
    }))
    pq.peek()
  }
}
