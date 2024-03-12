package leetCode._400

object Solution_395 {
  def longestSubstring(s: String, k: Int): Int = {
    if (s.isEmpty) 0
    else {
      val ch = 'a' to 'z'
      val cnt = ch.toList.map(c => s.count(_ == c))
      if (cnt.filter(_ > 0).min >= k) s.length
      else {
        val suf = s.span(x => cnt(x - 'a') < k)._2
        val (s1, s2) = suf.span(x => cnt(x - 'a') >= k)
        longestSubstring(s1, k).max(longestSubstring(s2, k))
      }
    }
  }
}
