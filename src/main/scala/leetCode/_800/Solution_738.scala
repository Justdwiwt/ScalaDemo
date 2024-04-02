package leetCode._800

object Solution_738 {
  def monotoneIncreasingDigits(n: Int): Int =
    monotoneIncreasingDigits(n.digits)

  @scala.annotation.tailrec
  private def monotoneIncreasingDigits(digits: Seq[Int], stack: Seq[Int] = Nil): Int = (digits, stack) match {
    case (Seq(), stack) => Iterator.iterate(1)(10 * _).zip(stack.iterator).map { case (x, y) => x * y }.sum
    case (Seq(digit, digits@_*), Seq()) => monotoneIncreasingDigits(digits, Seq(digit))
    case (Seq(digit, digits@_*), Seq(top, _*)) if digit >= top => monotoneIncreasingDigits(digits, digit +: stack)
    case (Seq(-1, digits@_*), Seq(top, stack@_*)) => monotoneIncreasingDigits((top - 1) +: 0 +: digits, stack)
    case (Seq(_, _*), Seq(top, stack@_*)) => monotoneIncreasingDigits((top - 1) +: Seq.fill(digits.length)(9), stack)
  }

  private implicit final class RichInt(x: Int) {
    def digits: Seq[Int] =
      digits(Nil)

    @scala.annotation.tailrec
    private def digits(suffix: Seq[Int]): Seq[Int] = x match {
      case 0 => suffix match {
        case Seq(_, _*) => suffix
        case _ => Seq(0)
      }
      case x => (x / 10).digits(x % 10 +: suffix)
    }
  }
}
