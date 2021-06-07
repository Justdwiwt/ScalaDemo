package leetCode

object Solution_1780 {
  def checkPowersOfThree(n: Int): Boolean = {
    if (n > 1) {
      if (n % 3 == 2) return false
      return checkPowersOfThree(n / 3)
    }
    true
  }
}
