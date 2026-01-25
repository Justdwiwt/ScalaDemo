package leetCode._3800

object Solution_3772 {
  def maxSubgraphScore(n: Int, edges: Array[Array[Int]], good: Array[Int]): Array[Int] = {
    val g: Vector[Vector[Int]] = edges
      .foldLeft(Vector.fill(n)(Vector.empty[Int]))((acc, e) => {
        val x = e(0)
        val y = e(1)

        acc
          .updated(x, acc(x) :+ y)
          .updated(y, acc(y) :+ x)
      })

    val ans = Array.ofDim[Int](n)

    def dfs(x: Int, fa: Int): Unit = {
      val self = if (good(x) != 0) 1 else -1

      ans(x) = g(x)
        .filter(_ != fa)
        .foldLeft(self)((sum, y) => {
          dfs(y, x)
          sum + ans(y).max(0)
        })
    }

    def reroot(x: Int, fa: Int): Unit = g(x)
      .filter(_ != fa)
      .foreach(y => {
        val fromParent = ans(x) - ans(y).max(0)
        ans(y) += fromParent.max(0)
        reroot(y, x)
      })

    dfs(0, -1)
    reroot(0, -1)
    ans
  }
}
