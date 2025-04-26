package leetCode._2600

object Solution_2581 {
  def rootCount(edges: Array[Array[Int]], guesses: Array[Array[Int]], k: Int): Int = {
    val n = edges.length + 1
    val g: Array[List[Int]] = Array.fill(n)(Nil)
    edges.foreach { case Array(x, y) =>
      g(x) = y :: g(x)
      g(y) = x :: g(y)
    }

    val s = guesses.map { case Array(x, y) => (x, y) }.toSet

    def dfs(x: Int, fa: Int): Int =
      g(x).filter(_ != fa).map(y => (if (s((x, y))) 1 else 0) + dfs(y, x)).sum

    val cnt0 = dfs(0, -1)

    def f(x: Int, fa: Int, cnt: Int): Int =
      g(x).filter(_ != fa).foldLeft(if (cnt >= k) 1 else 0) { (acc, y) =>
        val newCnt = cnt - (if (s((x, y))) 1 else 0) + (if (s((y, x))) 1 else 0)
        acc + f(y, x, newCnt)
      }

    f(0, -1, cnt0)
  }
}
