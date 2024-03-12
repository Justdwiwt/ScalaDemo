package leetCode._2300

object Solution_2207 {
  def maximumSubsequenceCount(text: String, pattern: String): Long = {
    def f(s: String): Long = {
      var t = 0L
      var res = 0L
      s.foreach(c => {
        if (c == pattern(1)) res += t
        if (c == pattern.head) t += 1
      })
      res
    }

    f(pattern.head + text).max(f(text + pattern(1)))
  }
}
