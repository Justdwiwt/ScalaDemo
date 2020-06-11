package leetCode

object Solution_1328 {
  def breakPalindrome(palindrome: String): String = {
    if (palindrome == null || palindrome.length <= 1) return ""
    (0 until palindrome.length / 2).foreach(i => if (palindrome(i) != 'a') return palindrome.substring(0, i) + 'a' + palindrome.substring(i + 1))
    palindrome.substring(0, palindrome.length - 1) + 'b'
  }
}
