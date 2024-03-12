package leetCode._300

object Solution_214 {
  def shortestPalindrome(s: String): String = {
    val r = s.reverse
    s
      .indices
      .find(i => s.startsWith(r.substring(i)))
      .map(r.substring(0, _) + s)
      .getOrElse("")
  }
}
