package leetCode._3400

object Solution_3302 {
  def validSequence(word1: String, word2: String): Array[Int] = {
    val n = word1.length
    val m = word2.length

    val suf: Array[Int] = {
      val tempSuf = Array.fill(n + 1)(m)
      val jInit = m - 1
      word1.indices.reverse.foldLeft((tempSuf, jInit)) { case ((suf, j), i) =>
        val newJ = if (j >= 0 && word1(i) == word2(j)) j - 1 else j
        suf(i) = newJ + 1
        (suf, newJ)
      }._1
    }

    @scala.annotation.tailrec
    def f(i: Int, j: Int, changed: Boolean, acc: List[Int]): Array[Int] =
      if (j == m) acc.reverse.toArray
      else if (i >= n) Array.empty[Int]
      else if (word1(i) == word2(j) || (!changed && suf(i + 1) <= j + 1)) {
        val newChanged = if (word1(i) != word2(j)) true else changed
        f(i + 1, j + 1, newChanged, i :: acc)
      } else f(i + 1, j, changed, acc)

    f(0, 0, changed = false, Nil)
  }
}
