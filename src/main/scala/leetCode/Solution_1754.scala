package leetCode

object Solution_1754 {
  def largestMerge(word1: String, word2: String): String = {
    val res = new StringBuilder
    var i1, i2 = 0

    @scala.annotation.tailrec
    def f(i1: Int, i2: Int): Boolean = {
      if (i2 >= word2.length) true
      else if (i1 >= word1.length) false
      else if (word1(i1) > word2(i2)) true
      else if (word1(i1) < word2(i2)) false
      else f(i1 + 1, i2 + 1)
    }

    while (i1 < word1.length && i2 < word2.length) {
      if (f(i1, i2)) {
        res.append(word1(i1))
        i1 += 1
      } else {
        res.append(word2(i2))
        i2 += 1
      }
    }
    if (i1 < word1.length) res.appendAll(word1.drop(i1))
    if (i2 < word2.length) res.appendAll(word2.drop(i2))
    res.mkString
  }
}
