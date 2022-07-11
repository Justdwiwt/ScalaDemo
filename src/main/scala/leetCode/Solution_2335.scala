package leetCode

object Solution_2335 {
  def fillCups(amount: Array[Int]): Int =
    amount.max.max((amount.sum + 1) / 2)
}
