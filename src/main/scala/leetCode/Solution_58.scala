package leetCode

object Solution_58 {
  def lengthOfLastWord(s: String): Int = {
    val words = s.split(" ")
    if (words == null || words.isEmpty) return 0
    words.last.length
  }
}
