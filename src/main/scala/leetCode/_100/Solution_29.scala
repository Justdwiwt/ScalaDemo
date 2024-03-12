package leetCode._100

object Solution_29 {
  def divide(dividend: Int, divisor: Int): Int = {
    if (isIllegal(dividend, divisor)) Int.MaxValue
    else f(isNeg(dividend, divisor))(help(f(dividend > 0)(dividend), f(divisor > 0)(divisor), 0))
  }

  @scala.annotation.tailrec
  def help(a: Int, b: Int, acc: Int): Int = if (a > b) acc else help(a - b, b, acc + 1)

  def f(p: Boolean)(x: Int): Int = if (p) -x else x

  def isNeg(a: Int, b: Int): Boolean = {
    (a > 0 && b < 0) || (a < 0 && b > 0)
  }

  def isIllegal(a: Int, b: Int): Boolean = {
    a == Int.MinValue && b == -1
  }
}
