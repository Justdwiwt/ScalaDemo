package leetCode

object Solution_2119 {
  def isSameAfterReversals(num: Int): Boolean = {
    if (num == 0) true else num % 10 != 0
  }
}
