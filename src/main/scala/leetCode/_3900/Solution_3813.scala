package leetCode._3900

object Solution_3813 {
  def vowelConsonantScore(s: String): Int = {
    val vowels = Set('a', 'e', 'i', 'o', 'u')

    val (v, c) = s.foldLeft((0, 0)) { case ((v, c), ch) =>
      if (vowels.contains(ch)) (v + 1, c)
      else if (ch.isLetter) (v, c + 1)
      else (v, c)
    }

    if (c == 0) 0 else v / c
  }
}
