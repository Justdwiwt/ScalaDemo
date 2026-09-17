package leetCode._4000

object Solution_3992 {
  def rearrangeString(s: String, x: Char, y: Char): String =
    s.filter(_ == y) + s.filterNot(_ == y)
}
