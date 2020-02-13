package leetCode

object Offer_14_2 {
  def cuttingRope(n: Int): Int = n match {
    case 2 => 1
    case 3 => 2
    case _ =>
      var res = 1L
      var t = n
      while (t > 4) {
        res *= 3
        res = res % 1000000007
        t -= 3
      }
      (res * t % 1000000007).toInt
  }
}
