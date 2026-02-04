package leetCode._3900

object Solution_3805 {
  def normalize(s: String): String =
    if (s.isEmpty) s
    else {
      val d = s.head
      s.map(c => ((c - d + 26) % 26 + 'a').toChar)
    }

  def countPairs(words: Array[String]): Long = words
    .map(normalize)
    .groupBy(identity)
    .values
    .map(v => v.length.toLong * (v.length - 1) / 2)
    .sum
}
