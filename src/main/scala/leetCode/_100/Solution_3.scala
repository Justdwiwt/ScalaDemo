package leetCode._100

object Solution_3 {
  def lengthOfLongestSubstring(s: String): Int =
    s.toSeq./:((0, Seq.empty[Char])) { case ((max, cur), c) =>
      if (cur.contains(c)) max.max(cur.size) -> (c +: cur.takeWhile(_ != c))
      else max.max(cur.size + 1) -> (c +: cur)
    }._1
}
