package leetCode._2100

object Solution_2060 {
  def possiblyEquals(s1: String, s2: String): Boolean = {
    val visited = Array.ofDim[Boolean](s1.length + 1, s2.length + 1, 2000)
    dfs(s1, s2, visited, 0, 0, 0)
  }

  private def dfs(s1: String, s2: String, visited: Array[Array[Array[Boolean]]], a: Int, b: Int, d: Int): Boolean = {
    if (a == s1.length && b == s2.length && d == 0) return true
    if (visited(a)(b)(d + 1000)) return false

    visited(a)(b)(d + 1000) = true

    def matchLetters: Boolean =
      d == 0 && a < s1.length && b < s2.length && s1.charAt(a) == s2.charAt(b) && dfs(s1, s2, visited, a + 1, b + 1, 0)

    def matchS2Letters: Boolean =
      d > 0 && b < s2.length && s2.charAt(b).isLetter && dfs(s1, s2, visited, a, b + 1, d - 1)

    def matchS1Letters: Boolean =
      d < 0 && a < s1.length && s1.charAt(a).isLetter && dfs(s1, s2, visited, a + 1, b, d + 1)

    def matchS2Digits: Boolean = {
      val s2Digits = s2.drop(b).takeWhile(_.isDigit).scanLeft(0)((acc, c) => acc * 10 + (c - '0')).tail
      s2Digits.exists(num => dfs(s1, s2, visited, a, b + num.toString.length, d - num))
    }

    def matchS1Digits: Boolean = {
      val s1Digits = s1.drop(a).takeWhile(_.isDigit).scanLeft(0)((acc, c) => acc * 10 + (c - '0')).tail
      s1Digits.exists(num => dfs(s1, s2, visited, a + num.toString.length, b, d + num))
    }

    matchLetters || (d >= 0 && (matchS2Letters || matchS2Digits)) || (d <= 0 && (matchS1Letters || matchS1Digits))
  }
}
