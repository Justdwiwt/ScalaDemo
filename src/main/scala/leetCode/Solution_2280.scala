package leetCode

object Solution_2280 {
  def minimumLines(stockPrices: Array[Array[Int]]): Int = {
    val sorted = stockPrices.sortBy(_.head)
    val slopes = sorted.zip(sorted.tail).collect {
      case (Array(day1, price1), Array(day2, price2)) => Rational(price2 - price1, day2 - day1)
    }
    slopes
      .headOption
      .fold(0) {
        slopes
          .tail
          ./:(_, 1) { case ((pre, num), cur) => (cur, num + (if (pre == cur) 0 else 1)) }
          ._2
      }
  }

  private final case class Rational private(numerator: Int, denominator: Int)

  private object Rational {
    def apply(numerator: Int, denominator: Int): Rational = {
      val gcd = computeGcd(numerator, denominator)
      new Rational(numerator.signum * denominator.signum * numerator.abs / gcd, denominator.abs / gcd)
    }

    @scala.annotation.tailrec
    private def computeGcd(x: Int, y: Int): Int = y match {
      case 0 => x.abs
      case y => computeGcd(y, x % y)
    }
  }
}
