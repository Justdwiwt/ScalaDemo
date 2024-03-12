package leetCode._1900

object Solution_1876 {
  def countGoodSubstrings(s: String): Int =
    s.sliding(3, 1).count(_.distinct.length == 3)
}
