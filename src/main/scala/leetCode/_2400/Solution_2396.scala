package leetCode._2400

object Solution_2396 {
  def isStrictlyPalindromic(n: Int): Boolean = (2 to n - 2)
    .map(Integer.toString(n, _))
    .forall(s => s == s.reverse)
}
