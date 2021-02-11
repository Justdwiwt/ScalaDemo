package leetCode

object Solution_564 {
  def nearestPalindromic(n: String): String = {
    val nl = n.toLong
    val smallerHalf = n.length / 2
    val larger = smallerHalf + n.length % 2

    def f(n: String): String = {
      val half = n.length / 2
      n.take(half + n.length % 2) + n.take(half).reverse
    }

    def g(candidates: String*): String = candidates
      .filter(_ != n)
      .minBy(s => ((s.toLong - nl).abs, s.toLong))

    if (n == "0") "1"
    else if (n.length == 1) (n.toInt - 1).toString
    else {
      val lower = (n.take(larger) + "0" * smallerHalf).toLong
      g(
        f(n),
        f((lower - 1).toString),
        f((lower + ("1" + "0" * smallerHalf).toLong).toString))
    }
  }
}
