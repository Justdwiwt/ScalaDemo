package leetCode._1600

object Solution_1510 {
  def winnerSquareGame(n: Int): Boolean = {
    val dp = Array.fill(n + 1)(false)
    (1 to n).foreach(i => {
      var j = 1
      while (j * j <= i) {
        if (!dp(i - j * j)) dp(i) = true
        j += 1
      }
    })
    dp(n)
  }
}
