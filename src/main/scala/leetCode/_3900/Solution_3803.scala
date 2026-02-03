package leetCode._3900

object Solution_3803 {
  def residuePrefixes(s: String): Int = {
    s.zipWithIndex.foldLeft(Set[Char](), 0) { case ((charSet, count), (ch, i)) =>
      val newSet = charSet + ch
      val prefixLengthMod = (i + 1) % 3
      val increment = if (prefixLengthMod == newSet.size) 1 else 0
      (newSet, count + increment)
    }._2
  }
}
