package leetCode._3800

object Solution_3733 {
  def minimumTime(d: Array[Int], r: Array[Int]): Long =
    (d.map(_.toLong), r.map(_.toLong)) match {
      case (Array(a, b), Array(x, y)) =>
        val f = (d: Long, r: Long) => d + (d - 1) / (r - 1)
        List(f(a, x), f(b, y), f(a + b, lcm(x, y))).max
    }

  @scala.annotation.tailrec
  private def gcd(a: Long, b: Long): Long =
    if (b == 0) a else gcd(b, a % b)

  private def lcm(a: Long, b: Long): Long =
    a / gcd(a, b) * b
}
