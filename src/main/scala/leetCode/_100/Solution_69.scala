package leetCode._100

object Solution_69 {
  def mySqrt(n: Int): Int = {
    if (n == 0) return 0

    @scala.annotation.tailrec
    def f(n: Int, cnt: Int = 1, odd: Int = 1): Int = n.compare(odd) match {
      case 0 | -1 | 1 if (n - odd) - (odd + 2) < 0 => cnt
      case _ => f(n - odd, cnt + 1, odd + 2)
    }

    f(n)
  }
}
