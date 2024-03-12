package leetCode._100

object Solution_58 {
  def lengthOfLastWord(s: String): Int =
    s.trim.split(" ").last.length
}
