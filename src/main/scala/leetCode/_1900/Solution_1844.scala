package leetCode._1900

object Solution_1844 {
  def replaceDigits(s: String): String = s
    .zipWithIndex
    .map(p => if (p._2 % 2 == 0) p._1 else f(s(p._2 - 1), p._1.asDigit)).mkString

  def f(c: Char, x: Int): Char = (c.toInt + x).toChar
}
