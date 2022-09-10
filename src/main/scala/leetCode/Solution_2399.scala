package leetCode

object Solution_2399 {
  def checkDistances(s: String, distance: Array[Int]): Boolean = {
    def f(c: Char): Boolean = {
      val i = s.indexOf(c)
      val j = s.indexOf(c, i + 1)
      distance(c - 97) == j - i - 1
    }

    s.distinct.forall(f)
  }
}
