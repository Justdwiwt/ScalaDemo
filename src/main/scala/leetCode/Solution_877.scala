package leetCode

object Solution_877 {
  def stoneGame(piles: Array[Int]): Boolean = {
    val dp = Array.fill(piles.length, piles.length)(0)
    piles.indices.foreach(i => dp(i)(i) = piles(i))
    (1 until piles.length).foreach(i => (0 until piles.length - i).foreach(j => {
      val t = j + i
      dp(j)(t) = (piles(j) - dp(j + 1)(t)).max(piles(t) - dp(j)(t - 1))
    }))
    dp(0)(piles.length - 1) > 0
  }
}
