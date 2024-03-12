package leetCode.offer

object Offer_019 {
  def validPalindrome(s: String): Boolean = {
    val start = 0
    val end = s.length - 1

    @scala.annotation.tailrec
    def isPalindrome(start: Int, end: Int): Boolean = start match {
      case i if i >= end => true
      case i if s.charAt(i) != s.charAt(end) => confirmPalindrome(start + 1, end) || confirmPalindrome(start, end - 1)
      case _ => isPalindrome(start + 1, end - 1)
    }

    @scala.annotation.tailrec
    def confirmPalindrome(start: Int, end: Int): Boolean = start match {
      case i if i >= end => true
      case i if s.charAt(i) != s.charAt(end) => false
      case _ => confirmPalindrome(start + 1, end - 1)
    }

    isPalindrome(start, end)
  }
}
