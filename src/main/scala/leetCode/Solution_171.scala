package leetCode

object Solution_171 {
  def titleToNumber(s: String): Int = (0 /: s) ((_: Int) * 26 + _ - 64)
}
