package leetCode._800

object Solution_788 {
  def rotatedDigits(n: Int): Int =
    (1 to n).count(f(_) > 0)

  private def f(num: Int): Int = {
    val digits = num.toString.map(_.asDigit)
    if (digits.exists(e => e == 3 || e == 4 || e == 7)) 0
    else digits.count(c => c == 2 || c == 5 || c == 6 || c == 9)
  }
}
