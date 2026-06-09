package leetCode._4000

object Solution_3908 {
  def validDigit(n: Int, x: Int): Boolean = n
    .toString
    .contains(x.toString) && !n
    .toString
    .startsWith(x.toString)
}
