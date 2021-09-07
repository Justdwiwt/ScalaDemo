package leetCode

object Solution_1796 {
  def secondHighest(s: String): Int = {
    val sorted = s.filter(_.isDigit).distinct.sorted
    if (sorted.length > 1) sorted.init.last.asDigit else -1
  }
}
