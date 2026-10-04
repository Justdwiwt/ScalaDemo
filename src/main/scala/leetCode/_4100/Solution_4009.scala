package leetCode._4100

object Solution_4009 {
  def minMaxWaitingTime(demand: Array[Int], fuel: Array[Int]): Int = {
    val memo = collection.mutable.Map.empty[(Int, Int, Int, Int), (Int, Int)]

    def dfs(i: Int, w1: Int, f0: Int, f1: Int): (Int, Int) =
      memo.getOrElseUpdate((i, w1, f0, f1), {
        if (i == demand.length) (0, 0)
        else {
          val w0 = if (i == 0) 0 else demand(i - 1)
          val d = demand(i)

          val a = if (d <= f0) {
            val (n, w) = dfs(i + 1, (w1 - w0).max(0), f0 - d, f1)
            (n - 1, w.max(w0))
          } else (0, 0)

          if (d <= f1) {
            val (n, w) = dfs(i + 1, (w0 - w1).max(0), f1 - d, f0)
            val b = (n - 1, w.max(w1))

            if (b._1 < a._1 || b._1 == a._1 && b._2 < a._2) b
            else a
          } else a
        }
      })

    val (n, ans) = dfs(0, 0, fuel(0), fuel(1))
    if (n == 0) -1 else ans
  }
}
