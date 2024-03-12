package leetCode._1800

object Solution_1761 {
  def minTrioDegree(n: Int, edges: Array[Array[Int]]): Int = {
    val g = Array.ofDim[Int](n, n)
    val degree = new Array[Int](n)
    edges.foreach(edge => {
      val x = edge.head - 1
      val y = edge(1) - 1
      g(x)(y) = 1
      g(y)(x) = 1
      degree(x) += 1
      degree(y) += 1
    })
    var res = Int.MaxValue
    (0 until n)
      .foreach(i => ((i + 1) until n)
        .withFilter(j => g(i)(j) == 1)
        .foreach(j => ((j + 1) until n)
          .withFilter(k => g(i)(k) == 1 && g(j)(k) == 1)
          .foreach(k => res = res.min(degree(i) + degree(j) + degree(k) - 6))))
    if (res == Int.MaxValue) -1 else res
  }
}
