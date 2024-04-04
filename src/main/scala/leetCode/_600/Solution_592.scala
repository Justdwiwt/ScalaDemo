package leetCode._600

object Solution_592 {
  private val Pattern = """([+\-])*(\d+)/(\d+)""".r

  def fractionAddition(expression: String): String = Pattern
    .findAllMatchIn(expression)
    .map(m => Fraction(Option(m.group(1))
      .getOrElse("")
      .iterator.map { case '+' => 1 case _ => -1 }
      .product * m.group(2)
      .toInt, m
      .group(3)
      .toInt))
    .fold(Fraction(0))(_ + _)
    .toString

  private final case class Fraction private(numerator: Int, denominator: Int) {
    def +(that: Fraction): Fraction = (this, that) match {
      case (Fraction(n1, d1), Fraction(n2, d2)) =>
        val lcm = Fraction.computeLcm(d1, d2)
        Fraction(n1 * lcm / d1 + n2 * lcm / d2, lcm)
    }

    override def toString: String = numerator.toString + "/" + denominator
  }

  private object Fraction {
    def apply(numerator: Int) = new Fraction(numerator, 1)

    def apply(numerator: Int, denominator: Int): Fraction = {
      val gcd = computeGcd(numerator, denominator)
      new Fraction(numerator / gcd, denominator / gcd)
    }

    @scala.annotation.tailrec
    private def computeGcd(x: Int, y: Int): Int =
      if (y == 0) x.abs else computeGcd(y, x % y)

    private def computeLcm(x: Int, y: Int) =
      (x * y / computeGcd(x, y)).abs
  }
}
