package leetCode._600

object Solution_592 {
  def fractionAddition(expression: String): String = {
    val p = "([+-]?[0-9]+)/([0-9]+)".r
    var r = new F(0, 1)
    p.findAllMatchIn(expression).foreach({ case p(a, b) => r = F.add(r, new F(a.toLong, b.toLong)) })
    r.toString()
  }
}

class F(val num: Long, val den: Long) {
  override def toString: String = num.toString + "/" + den
}

object F {
  def add(a: F, b: F): F = {
    val g = gcd(a.den, b.den)
    val den0 = a.den / g * b.den
    val num0 = b.den / g * a.num + a.den / g * b.num
    val g0 = gcd(num0, den0)
    new F(num0 / g0, den0 / g0)
  }

  def gcd(a: Long, b: Long): Long = {
    if (a == 0) return b
    if (a < 0) return gcd(-a, b)
    var x = a
    var y = b
    while (y != 0) {
      val r = x % y
      x = y
      y = r
    }
    x
  }
}
