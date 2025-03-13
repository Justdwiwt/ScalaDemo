package leetCode._500

object Solution_3466 {
  def maxCoins(lane1: Array[Int], lane2: Array[Int]): Long = {
    val initialState: (Long, Long, Long, Long) = (0L, Long.MinValue, Long.MinValue, Long.MinValue)

    val finalState = lane1.indices.foldLeft(initialState)((state, i) => {
      val (dp0, dp1, dp2, maxSoFar) = state
      val coins1 = lane1(i)
      val coins2 = lane2(i)
      val newDp0 = dp0.max(0L) + coins1
      val newDp1 = dp0.max(dp1).max(0L) + coins2
      val newDp2 = dp1.max(dp2).max(0L) + coins1
      val newMax = List(maxSoFar, newDp0, newDp1, newDp2).max
      (newDp0, newDp1, newDp2, newMax)
    })

    finalState._4
  }
}
