package leetCode

object Solution_2739 {
  def distanceTraveled(mainTank: Int, additionalTank: Int): Int =
    (mainTank + ((mainTank - 1) / 4).min(additionalTank)) * 10
}
