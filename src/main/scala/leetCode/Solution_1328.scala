package leetCode

object Solution_1328 {
  def breakPalindrome(palindrome: String): String =
    if (palindrome.length <= 1) ""
    else palindrome.indexWhere(_ != 'a') match {
      case i if i >= 0 && !(palindrome.length / 2 == i && palindrome.length % 2 == 1) =>
        palindrome.substring(0, i) + "a" + palindrome.substring(i + 1)
      case _ =>
        palindrome.substring(0, palindrome.length - 1) + "b"
    }
}
