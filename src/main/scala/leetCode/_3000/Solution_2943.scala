package leetCode._3000

object Solution_2943 {
  def maximizeSquareHoleArea(n: Int, m: Int, hBars: Array[Int], vBars: Array[Int]): Int = {
    val sortedH = hBars.sorted
    val sortedV = vBars.sorted
    var dp = Array.fill(sortedH.length)(0)
    dp(0) = if (sortedH.head == 1) 1 else 2
    var mx1 = dp.head
    sortedH.indices.drop(1).foreach(i => {
      if (sortedH(i) == n + 2) dp(i) = dp(i - 1)
      else if (sortedH(i) == sortedH(i - 1) + 1) dp(i) = dp(i - 1) + 1
      else dp(i) = 2
      mx1 = mx1.max(dp(i))
    })
    dp = Array.fill(sortedV.length)(0)
    dp(0) = if (sortedV.head == 1) 1 else 2
    var mx2 = dp.head
    sortedV.indices.drop(1).foreach(i => {
      if (sortedV(i) == m + 2) dp(i) = dp(i - 1)
      else if (sortedV(i) == sortedV(i - 1) + 1) dp(i) = dp(i - 1) + 1
      else dp(i) = 2
      mx2 = mx2.max(dp(i))
    })
    val mx = mx1.min(mx2)
    mx * mx
  }
}
