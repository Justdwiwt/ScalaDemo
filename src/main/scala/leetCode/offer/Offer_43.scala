package leetCode.offer

object Offer_43 {
  def countDigitOne(n: Int): Int = {
    if (n <= 0) return 0
    if (n < 10) return 1
    val s = n.toString
    val highNum = s.head - '0'
    val withoutHigh = (n - highNum * math.pow(10, s.length - 1)).toInt
    val first = if (highNum == 1) withoutHigh + 1 else math.pow(10, s.length - 1).toInt
    val other = highNum * (s.length - 1) * math.pow(10, s.length - 2).toInt
    first + other + countDigitOne(withoutHigh)
  }
}
