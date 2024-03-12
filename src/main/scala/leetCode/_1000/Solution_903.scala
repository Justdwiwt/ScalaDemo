package leetCode._1000

object Solution_903 {
  def numPermsDISequence(S: String): Int = {
    val M = math.pow(10, 9).toInt + 7
    val dp = Array.fill(S.length + 1, S.length + 1)(0)
    dp(0)(0) = 1
    S.indices.foreach(i => S(i) match {
      case 'I' => (1 to i + 1).foreach(j => dp(i + 1)(j) = (dp(i + 1)(j - 1) + dp(i)(j - 1)) % M)
      case 'D' => (i to 0 by -1).foreach(j => dp(i + 1)(j) = (dp(i + 1)(j + 1) + dp(i)(j)) % M)
    })
    (0 to S.length).map(dp(S.length))./:(0)((sum, x) => (sum + x) % M)
  }
}
