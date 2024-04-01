package leetCode._900

object Solution_851 {
  def loudAndRich(richer: Array[Array[Int]], quiet: Array[Int]): Array[Int] = {
    val arr = Array.ofDim[Boolean](quiet.length, quiet.length)
    richer.indices.foreach(i => arr(richer(i).head)(richer(i)(1)) = true)
    val res = (-quiet.length to -1).toArray

    def dfs(node: Int): Int = {
      if (res(node) < 0) {
        res(node) = node
        quiet.indices.withFilter(i => arr(i)(node)).foreach(i => {
          val t = dfs(i)
          if (quiet(t) < quiet(res(node))) res(node) = t
        })
      }
      res(node)
    }

    quiet.indices.map(dfs).toArray
  }
}
