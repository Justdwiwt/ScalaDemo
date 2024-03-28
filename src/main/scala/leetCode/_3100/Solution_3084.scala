package leetCode._3100

object Solution_3084 {
  def countSubstrings(s: String, c: Char): Long =
    (0 to s.count(c == _)).foldLeft(0L)(_ + _)
}
