package leetCode._3000

object Solution_2957 {
  def removeAlmostEqualCharacters(word: String): Int = {
    val n = word.length

    @scala.annotation.tailrec
    def f(i: Int, res: Int): Int = {
      if (i >= n - 1) return res
      val c = word(i)
      val d = word(i + 1)
      if (c == d || (c + 1) == d || (c - 1) == d) f(i + 2, res + 1)
      else f(i + 1, res)
    }

    f(0, 0)
  }
}
