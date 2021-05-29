package leetCode

object Solution_507 {
  def checkPerfectNumber(num: Int): Boolean =
    (1 until num).filter(i => num % i == 0).sum == num
}
