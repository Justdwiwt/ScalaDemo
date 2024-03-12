package leetCode._2500

object Solution_2405 {
  def partitionString(s: String): Int = s
    ./:((1, Set.empty[Char])) { case ((cnt, set), c) =>
      if (set(c)) (cnt + 1, Set(c))
      else (cnt, set + c)
    }
    ._1
}
