package leetCode.offer

object Offer_002 {
  def addBinary(a: String, b: String): String = {
    val s1 = if (a.length > b.length) a else b
    val s2 = if (s1 == a) b else a
    val (_, buff, carry) = s1.:\(s2.length - 1, "", 0) {
      case (bit, (idx, buff, carry)) =>
        val t = if (idx >= 0) s2(idx) else '0'
        (bit - '0', t - '0', carry) match {
          case (1, 1, 0) => (idx - 1, 0 + buff, 1)
          case (1, 1, 1) => (idx - 1, 1 + buff, 1)
          case (0, 0, 0) => (idx - 1, 0 + buff, 0)
          case (0, 0, 1) => (idx - 1, 1 + buff, 0)
          case (_, _, 1) => (idx - 1, 0 + buff, 1)
          case _ => (idx - 1, 1 + buff, 0)
        }
    }
    if (carry == 1) 1 + buff else buff
  }
}
