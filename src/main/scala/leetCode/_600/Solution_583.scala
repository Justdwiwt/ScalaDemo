package leetCode._600

object Solution_583 {
  def minDistance(word1: String, word2: String): Int = {
    val m = collection.mutable.Map.empty[(Seq[Char], Seq[Char]), Int]

    def f(w1: Seq[Char], w2: Seq[Char]): Int =
      if (w1.isEmpty) w2.size
      else if (w2.isEmpty) w1.size
      else if (m.contains(w1, w2)) m(w1, w2)
      else {
        lazy val rc = if (w1.head == w2.head) f(w1.tail, w2.tail)
        else f(w1, w2.tail).min(f(w1.tail, w2)) + 1
        m += ((w1, w2) -> rc)
        rc
      }

    f(word1.toList, word2.toList)
  }
}
