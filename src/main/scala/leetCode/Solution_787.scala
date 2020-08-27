package leetCode

object Solution_787 {
  def dfsSearch(n: Int, flights: Array[Array[Int]], src: Int, dst: Int, k: Int): Int = {
    var res = Int.MaxValue
    val price = Array.fill(n, n)(10000)
    val graph = Array.fill(n, n)(0)

    flights.foreach(i => {
      price(i(0))(i(1)) = i(2)
      graph(i(0))(i(1)) = 1
    })

    def dfs(node: Int, path: List[Int], cost: Int): Unit = {
      if (node == dst) if (path.length <= k + 1) res = res.min(cost)
      else (0 until n)
        .withFilter(next => graph(node)(next) == 1)
        .withFilter(next => !path.contains(next))
        .withFilter(_ => path.length <= k + 1)
        .foreach(next => dfs(next, node :: path, cost + price(node)(next)))
    }

    dfs(src, Nil, 0)
    if (res == Int.MaxValue) -1 else res
  }

  def findCheapestPrice(n: Int, flights: Array[Array[Int]], src: Int, dst: Int, k: Int): Int = {
    val dp = Array.fill(n, k + 2)(Int.MaxValue)
    (0 to k + 1).foreach(i => dp(src)(i) = 0)
    (1 to k + 1).foreach(i => flights.foreach(flight => if (dp(flight(0))(i - 1) != Int.MaxValue)
      dp(flight(1))(i) = dp(flight(1))(i).min(dp(flight(0))(i - 1) + flight(2))))
    if (dp(dst)(k + 1) == Int.MaxValue) -1 else dp(dst)(k + 1)
  }
}
