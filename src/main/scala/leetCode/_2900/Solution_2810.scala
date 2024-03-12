package leetCode._2900

object Solution_2810 {
  def finalString(s: String): String = s
    ./:(List.empty[Char])((acc, c) => if (c == 'i') acc.reverse else c :: acc)
    .reverse
    .mkString
}
