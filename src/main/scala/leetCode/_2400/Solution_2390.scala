package leetCode._2400

object Solution_2390 {
  def removeStars(s: String): String = s
    .foldLeft(List.empty[Char])((res, ch) => if (ch == '*') res.tail else ch +: res)
    .mkString
    .reverse
}
