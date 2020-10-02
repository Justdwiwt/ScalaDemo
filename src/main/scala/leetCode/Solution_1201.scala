package leetCode

object Solution_1201 {
  def nthUglyNumber(n: Int, a: Int, b: Int, c: Int): Int = {
    @scala.annotation.tailrec
    def gcd(x: Double, y: Double): Double = {
      if (y == 0) return x
      gcd(y, x % y)
    }

    val lcm: (Double, Double) => Double = (x, y) => x * y / gcd(x, y)
    val f: Double => Int = number => (number / a).toInt + (number / b).toInt + (number / c).toInt - (number / lcm(a, b)).toInt - (number / lcm(b, c)).toInt - (number / lcm(a, c)).toInt + (number / lcm(a, lcm(b, c))).toInt

    var s = 1
    var e = if (n.toDouble * Array(a, b, c).max > Int.MaxValue) Int.MaxValue else n * Array(a, b, c).max
    while (s < e) {
      val mid = s + (e - s) / 2
      val count = f(mid)
      if (count < n) s = mid + 1 else e = mid
    }
    e
  }
}
