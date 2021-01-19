package leetCode

object Solution_58 {
  def lengthOfLastWord(s: String): Int =
    s.trim.split(" ").last.length
}
