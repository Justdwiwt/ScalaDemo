package leetCode

object Solution_680 {
  def validPalindrome(s: String): Boolean = f(s)

  def f(s: String, flag: Boolean = false): Boolean =
    if (s.length < 2) true
    else if (s.head == s.last) f(s.drop(1).dropRight(1), flag)
    else if (s.head != s.last && !flag) f(s.drop(1), flag = true) || f(s.dropRight(1), flag = true)
    else false
}
