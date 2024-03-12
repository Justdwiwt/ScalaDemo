package leetCode._1800

object Solution_1763 {
  def longestNiceSubstring(s: String): String = {
    @scala.annotation.tailrec
    def f(left: Int, right: Int, pairs: Map[Char, Boolean], substr: String): String = {
      if (left == s.length) substr
      else if (right == s.length) f(left + 1, left + 1, Map.empty[Char, Boolean], substr)
      else {
        val rChar = s.charAt(right)
        val newPairs = if (pairs.contains(rChar) && pairs(rChar)) pairs
        else if (rChar.isUpper && pairs.contains(rChar.toLower)) pairs + (rChar.toLower -> true)
        else if (rChar.isLower && pairs.contains(rChar.toUpper)) pairs + (rChar.toUpper -> true)
        else pairs + (rChar -> false)
        val newSubstr = if (newPairs.forall(_._2) && right - left + 1 > substr.length) s.substring(left, right + 1) else substr
        f(left, right + 1, newPairs, newSubstr)
      }
    }

    f(0, 0, Map.empty[Char, Boolean], "")
  }
}
