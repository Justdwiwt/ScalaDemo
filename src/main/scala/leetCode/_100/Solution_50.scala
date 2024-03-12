package leetCode._100

object Solution_50 {
  def myPow(x: Double, n: Int): Double = n match {
    case 0 => 1
    case 1 => x
    case _ =>
      val f = myPow(x, n / 2)
      n % 2 match {
        case 0 => f * f
        case 1 => f * f * x
        case -1 => f * f / x
      }
  }
}
