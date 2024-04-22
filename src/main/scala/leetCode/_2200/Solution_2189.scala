package leetCode._2200

object Solution_2189 {
  def houseOfCards(n: Int): Int = {
    val dp = Array.fill(n + 1)(0)
    dp(0) = 1
    (2 to n by 3).foreach(num => (n to num by -1).foreach(j => dp(j) += dp(j - num)))
    dp(n)
  }
}
