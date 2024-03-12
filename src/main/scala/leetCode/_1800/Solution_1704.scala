package leetCode._1800

object Solution_1704 {
  def halvesAreAlike(s: String): Boolean = {
    val diff = Set('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
    val (x, y) = s.toList.splitAt(s.length / 2)
    x.count(diff.contains) == y.count(diff.contains)
  }
}
