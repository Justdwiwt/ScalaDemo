package leetCode

object Solution_72 {
  def minDistance(word1: String, word2: String): Int = f(word1, word2)

  lazy val f: (String, String) => Int = (s1, s2) =>
    s1./:((0 to s2.length).toList)((prev, x) =>
      prev.zip(prev.tail).zip(s2).scanLeft(prev.head + 1) {
        case (h, ((d, v), y)) => (h + 1).min(v + 1).min(d + (if (x == y) 0 else 1))
      }).last
}
