package leetCode

object Solution_983 {
  def mincostTickets(days: Array[Int], costs: Array[Int]): Int = {
    val last = days(days.length - 1)
    val dp = Array.fill(last + 1)(0)
    var idx = 0
    (1 to last).foreach(i => {
      if (i == days(idx)) {
        var cost = Int.MaxValue
        val oneDayAgo = i - 1
        val sevenDaysAgo = if (i - 7 > 0) i - 7 else 0
        val thirtyDaysAgo = if (i - 30 > 0) i - 30 else 0
        cost = (dp(oneDayAgo) + costs(0)).min(cost)
        cost = (dp(sevenDaysAgo) + costs(1)).min(cost)
        cost = (dp(thirtyDaysAgo) + costs(2)).min(cost)
        dp(i) = cost
        idx += 1
      } else dp(i) = dp(i - 1)
    })
    dp(last)
  }
}
