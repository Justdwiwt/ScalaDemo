package leetCode

object Solution_171 {
  def titleToNumber(s: String): Int =
    s./:(0)(_ * 26 + _ - 64)
}
