package leetCode._600

object Solution_507 {
  def checkPerfectNumber(num: Int): Boolean =
    (1 until num).filter(num % _ == 0).sum == num
}
