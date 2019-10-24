package leetCode

object Solution_67 {
  def addBinary(a: String, b: String): String = {
    var res = ""
    var m = a.length - 1
    var n = b.length - 1
    var carry = 0
    while (m >= 0 || n >= 0) {
      val p = if (m >= 0) a(m) - '0' else 0
      m -= 1
      val q = if (n >= 0) b(n) - '0' else 0
      n -= 1
      val sum = p + q + carry
      res = (sum % 2).toString + res
      carry = sum / 2
    }
    if (carry == 1) "1" + res else res
  }
}
