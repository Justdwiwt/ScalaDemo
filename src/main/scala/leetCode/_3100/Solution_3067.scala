package leetCode._3100

object Solution_3067 {
  def countPairsOfConnectableServers(edges: Array[Array[Int]], signalSpeed: Int): Array[Int] = {
    val n = edges.length + 1
    val g = Array.fill(n)(Array.empty[Array[Int]])
    edges.foreach(e => {
      val x = e.head
      val y = e(1)
      val wt = e(2)
      g(x) :+= Array(y, wt)
      g(x) :+= Array(x, wt)
    })
    val res = Array.fill(n)(0)
    (0 until n).foreach(i => {
      var sum = 0
      g(i).foreach(e => {
        val cnt = dfs(e.head, i, e(1), g, signalSpeed)
        res(i) += cnt * sum
        sum += cnt
      })
    })
    res
  }

  private def dfs(x: Int, fa: Int, sum: Int, g: Array[Array[Array[Int]]], signalSpeed: Int): Int = {
    var cnt = if (sum % signalSpeed == 0) 1 else 0
    g(x).foreach(e => {
      val y = e.head
      if (y != fa) cnt += dfs(y, x, sum + e(1), g, signalSpeed)
    })
    cnt
  }
}
