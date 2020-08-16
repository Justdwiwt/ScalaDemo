package leetCode

object Solution_518 {
  def change(amount: Int, coins: Array[Int]): Int = {
    val dp = Array.fill(amount + 1)(0)
    dp(0) = 1
    coins.foreach(coin => (1 to amount).foreach(j => if (j >= coin) dp(j) = dp(j) + dp(j - coin)))
    dp(amount)
  }
}
