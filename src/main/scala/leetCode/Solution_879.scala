package leetCode

object Solution_879 {
  def profitableSchemes(G: Int, P: Int, group: Array[Int], profit: Array[Int]): Int = {
    var res = 0
    val M = (1e9 + 7).toInt
    val dp = Array.ofDim[Int](G + 1, P + 1)
    dp(0)(0) = 1
    (1 to group.length).foreach(i => {
      val g = group(i - 1)
      val p = profit(i - 1)
      (G to g by -1).foreach(j => (P to 0 by -1).foreach(k => dp(j)(k) = (dp(j)(k) + dp(j - g)(math.max(0, k - p))) % M))
    })
    (0 to G).foreach(i => res = (res + dp(i)(P)) % M)
    res
  }
}
