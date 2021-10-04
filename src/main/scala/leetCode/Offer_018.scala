package leetCode

object Offer_018 {
  def isPalindrome(s: String): Boolean = {
    val filtered = s.filter(_.isLetterOrDigit)
    filtered.reverse.equalsIgnoreCase(filtered)
  }
}
