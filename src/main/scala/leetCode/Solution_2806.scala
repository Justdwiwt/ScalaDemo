package leetCode

object Solution_2806 {
  def accountBalanceAfterPurchase(amt: Int): Int =
    100 - (5 + amt) / 10 * 10
}
