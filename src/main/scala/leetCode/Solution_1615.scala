package leetCode

object Solution_1615 {
  def maximalNetworkRank(n: Int, roads: Array[Array[Int]]): Int = {
    val arr = Array.ofDim[Int](n, n)
    val degree = Array.fill(n)(0)
    roads.foreach(d => {
      arr(d.head)(d(1)) = 1
      arr(d(1))(d.head) = 1
      degree(d.head) += 1
      degree(d(1)) += 1
    })
    var res = 0
    (0 until n).foreach(i => (i + 1 until n).foreach(j => {
      var cur = degree(i) + degree(j)
      if (arr(i)(j) == 1 || arr(j)(i) == 1) cur -= 1
      res = res.max(cur)
    }))
    res
  }
}
