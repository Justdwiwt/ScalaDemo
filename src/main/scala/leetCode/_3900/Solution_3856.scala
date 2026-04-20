package leetCode._3900

object Solution_3856 {
  def trimTrailingVowels(s: String): String = s
    .reverse
    .dropWhile("aeiou".toSet.contains(_))
    .reverse
}
