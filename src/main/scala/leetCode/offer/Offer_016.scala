package leetCode.offer

object Offer_016 {
  def lengthOfLongestSubstring(s: String): Int = s
    .toSeq
    ./:((0, Seq.empty[Char])) { case ((mx, cur), c) =>
      if (cur.contains(c)) mx.max(cur.size) -> (c +: cur.takeWhile(_ != c))
      else mx.max(cur.size + 1) -> (c +: cur)
    }._1
}
