package leetCode._600

object Solution_537 {
  case class Complex(re: Int, im: Int) {
    override def toString: String = re.toString + "+" + im + "i"

    def f(that: Complex): Complex =
      Complex(this.re * that.re - this.im * that.im, this.re * that.im + this.im * that.re)
  }

  object Complex {
    def apply(s: String): Complex = {
      Complex(s.takeWhile(_ != '+').toInt, s.dropWhile(_ != '+').tail.takeWhile(_ != 'i').toInt)
    }
  }

  def complexNumberMultiply(num1: String, num2: String): String =
    String.valueOf(Complex(num1).f(Complex(num2)))
}
