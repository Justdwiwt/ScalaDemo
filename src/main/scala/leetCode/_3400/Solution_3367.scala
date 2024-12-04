package leetCode._3400

object Solution_3367 {
  def maximizeSumOfWeights(edges: Array[Array[Int]], k: Int): Long = {
    val g = Array.fill(edges.length + 1)(List.empty[(Int, Int)])
    edges.foreach { case Array(x, y, wt) =>
      g(x) = (y, wt) :: g(x)
      g(y) = (x, wt) :: g(y)
    }

    def dfs(x: Int, fa: Int): (Long, Long) = {
      var notChoose = 0L
      var inc = List.empty[Long]
      g(x).foreach { case (y, wt) =>
        if (y != fa) {
          val (nc, c) = dfs(y, x)
          notChoose += nc
          val d = c + wt - nc
          if (d > 0) inc = d :: inc
        }
      }
      inc = inc.sorted.reverse
      (notChoose + inc.take(k).sum, notChoose + inc.take(k - 1).sum)
    }

    dfs(0, -1)._1
  }
}
