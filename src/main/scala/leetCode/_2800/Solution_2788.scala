package leetCode._2800

object Solution_2788 {
  def splitWordsBySeparator(words: List[String], separator: Char): List[String] = words
    .flatMap(_.split(separator))
    .filter(_.nonEmpty)
}
