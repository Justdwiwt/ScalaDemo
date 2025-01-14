package leetCode._3500

object Solution_3413 {
  def maximumCoins(coins: Array[Array[Int]], k: Int): Long = {
    val sortedCoins = coins.map(_.map(_.toLong)).sortBy(_.head)
    val forwardMax = maximumCovered(sortedCoins, k)
    val reversedCoins = sortedCoins.map { case Array(l, r, c) => Array(-r, -l, c) }.sortBy(_.head)
    val backwardMax = maximumCovered(reversedCoins, k)
    forwardMax.max(backwardMax)
  }

  private def maximumCovered(coins: Array[Array[Long]], carpetLen: Long): Long = {
    var cover = 0L
    var left = 0
    coins.foldLeft(0L)((res, coin) => {
      val tl = coin(0)
      val tr = coin(1)
      val c = coin(2)
      cover += (tr - tl + 1) * c
      while (coins(left)(1) < tr - carpetLen + 1) {
        cover -= (coins(left)(1) - coins(left).head + 1) * coins(left)(2)
        left += 1
      }
      val uncover = 0L.max((tr - carpetLen + 1 - coins(left).head) * coins(left)(2))
      res.max(cover - uncover)
    })
  }
}
