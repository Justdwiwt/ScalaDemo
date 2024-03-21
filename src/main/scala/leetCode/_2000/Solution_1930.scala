package leetCode._2000

object Solution_1930 {
  def countPalindromicSubsequence(s: String): Int = {
    val diff = 'a' to 'z'
    var res = 0
    diff
      .map { ch => val left = s.indexWhere(_ == ch); (ch, left) }
      .withFilter { case (_, left) => left != -1 }
      .map { case (ch, left) => val right = s.lastIndexWhere(_ == ch); (ch, left, right) }
      .withFilter { case (_, left, right) => left < right - 1 }
      .foreach { case (_, left, right) =>
        val sub = s.slice(left + 1, right)
        diff
          .withFilter(sub.contains(_))
          .foreach(_ => res += 1)
      }
    res
  }
}
