package leetCode._3500

object Solution_3429 {
  def minCost(n: Int, cost: Array[Array[Int]]): Long = {
    val memo = collection.mutable.Map[(Int, Int, Int), Long]()

    def dfs(i: Int, preJ: Int, preK: Int): Long = {
      if (i < 0) return 0L
      memo.get((i, preJ, preK)) match {
        case Some(res) => res
        case None =>
          var res = Long.MaxValue
          cost(i).indices.foreach(j => if (j != preJ) cost(n - 1 - i).indices.foreach(k =>
            if (k != preK && k != j) res = res.min(dfs(i - 1, j, k) + cost(i)(j) + cost(n - 1 - i)(k))))
          memo((i, preJ, preK)) = res
          res
      }
    }

    dfs(n / 2 - 1, 3, 3)
  }
}
