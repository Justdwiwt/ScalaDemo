package leetCode._2900

object Solution_2828 {
  def isAcronym(words: List[String], s: String): Boolean =
    words.map(_.head).mkString == s
}
