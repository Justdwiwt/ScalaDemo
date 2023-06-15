package leetCode

object Solution_2730 {
  def longestSemiRepetitiveSubstring(s: String): Int =
    f(s.head, s.toList.tail, 1, 1, 0)

  @scala.annotation.tailrec
  private def f(c: Char, chars: List[Char], notRepeated: Int, repeated: Int, max: Int): Int = chars match {
    case Nil => max.max(repeated)
    case h :: tail =>
      if (c == h) f(h, tail, 1, notRepeated + 1, max.max(repeated))
      else f(h, tail, notRepeated + 1, repeated + 1, max)
  }
}
