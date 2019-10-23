package leetCode

object Solution_557 {
  def reverseWords(s: String): String = {
    s.split(" ").map(_.reverse).mkString(" ")
  }
}
