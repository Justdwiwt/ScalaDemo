package leetCode._2500

object Solution_2445 {
  def numberOfNodes(n: Int, queries: Array[Int]): Int = {
    val cnt = queries.groupBy(identity).mapValues(_.length)

    def dfs(node: Int, c: Int): Int =
      if (node > n) 0
      else {
        val nc = (c + cnt.getOrElse(node, 0)) % 2
        val res = nc + dfs(node * 2, nc) + dfs(node * 2 + 1, nc)
        res
      }

    dfs(1, 0)
  }
}
