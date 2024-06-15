package leetCode._2000

object Solution_1928 {
  def minCost(maxTime: Int, edges: Array[Array[Int]], passingFees: Array[Int]): Int = {
    val n = passingFees.length
    val initialDP = Array.fill(maxTime + 1, n)(Int.MaxValue / 2)
    initialDP(0)(0) = passingFees.head

    val dp = (1 to maxTime).foldLeft(initialDP)((dp, t) => {
      edges.foldLeft(dp)((dp, edge) => {
        val i = edge.head
        val j = edge(1)
        val cost = edge(2)

        if (cost <= t) {
          dp(t)(i) = dp(t)(i).min(dp(t - cost)(j) + passingFees(i))
          dp(t)(j) = dp(t)(j).min(dp(t - cost)(i) + passingFees(j))
        }
        dp
      })
    })

    val totalTime = (1 to maxTime).map(dp(_)(n - 1)).min

    if (totalTime == Int.MaxValue / 2) -1 else totalTime
  }
}
