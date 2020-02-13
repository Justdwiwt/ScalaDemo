package leetCode

object Offer_16 {
  def myPow(x: Double, n: Int): Double = n match {
    case 0 => 1
    case 1 => x
    case -1 => 1 / x
    case _ =>
      var res = myPow(x, n >> 1)
      res *= res
      if ((n & 1) > 0) res *= x
      res
  }
}
