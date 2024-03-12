package leetCode._2700

object Solution_2697 {
  def makeSmallestPalindrome(s: String): String = s
    .zip(s.reverse)
    .map(n => n._2.min(n._1))
    .mkString
}
