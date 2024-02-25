package leetCode

object Solution_3029 {
  def minimumTimeToInitialState(word: String, k: Int): Int = {
    @scala.annotation.tailrec
    def f(ls: String, rs: String, res: Int): Int =
      if (ls == rs) res
      else f(ls.drop(k), rs.dropRight(k), res + 1)

    f(word.drop(k), word.dropRight(k), 1)
  }
}
