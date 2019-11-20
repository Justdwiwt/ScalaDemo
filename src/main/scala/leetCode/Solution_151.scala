package leetCode

object Solution_151 {
  def reverseWords(s: String): String = s.trim.split("\\s+").reverse.mkString(" ")
}
