package leetCode._1000

object Solution_972 {
  case class Fraction[A] private(numerator: A, denominator: A)(implicit integral: Integral[A]) {
    private def simplify: Fraction[A] = {
      import integral.{abs, mkNumericOps, mkOrderingOps, zero}
      val gcd = Fraction.gcd(numerator, denominator)
      if (numerator >= zero ^ denominator < zero)
        new Fraction(abs(numerator / gcd), abs(denominator / gcd))
      else
        new Fraction(-abs(numerator / gcd), abs(denominator / gcd))
    }
  }

  private object Fraction {
    private val Rational = """(\d+)(?:\.(\d*)(?:\((\d+)\))?)?""".r

    def apply[A](numerator: A)(implicit integral: Integral[A]): Fraction[A] =
      Fraction(numerator, integral.one)

    def apply[A](numerator: A, denominator: A)(implicit integral: Integral[A]): Fraction[A] =
      new Fraction(numerator, denominator).simplify

    def apply(rational: String): Fraction[BigInt] = rational match {
      case Rational(integer, null, null) =>
        Fraction(BigInt(integer))
      case Rational(integer, nonRepeating, null) =>
        Fraction(BigInt(integer + nonRepeating), BigInt(10).pow(nonRepeating.length))
      case Rational(integer, nonRepeating, repeating) =>
        Fraction(BigInt(integer + nonRepeating + repeating) - BigInt(integer + nonRepeating),
          BigInt(10).pow(nonRepeating.length + repeating.length) - BigInt(10).pow(nonRepeating.length))
    }

    @scala.annotation.tailrec
    private def gcd[A](x: A, y: A)(implicit integral: Integral[A]): A = {
      import integral.{abs, mkNumericOps, zero}
      if (x == zero) abs(y)
      else if (y == zero) abs(x)
      else gcd(y, x % y)
    }
  }

  def isRationalEqual(s: String, t: String): Boolean =
    Fraction(s) == Fraction(t)
}
