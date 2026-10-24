package leetCode._4100

object Solution_4030 {
  def isPalindromic(s: String): Boolean = {
    def bits(c: Char): List[Char] =
      (0 until 8).map(i => ((c >> i) & 1).toChar).toList

    val a = s.map(bits)
    a == a.reverse.map(_.reverse)
  }
}
