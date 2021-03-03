package leetCode

object Solution_125 {
  def isPalindrome(s: String): Boolean = {
    val filtered = s.filter(_.isLetterOrDigit)
    filtered.reverse.equalsIgnoreCase(filtered)
  }
}
