package leetCode

object Solution_1556 {
  def thousandSeparator(n: Int): String = {
    n.toString.reverse.grouped(3).mkString(".").reverse
  }
}
