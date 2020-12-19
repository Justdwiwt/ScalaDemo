package leetCode

object Solution_819 {
  def mostCommonWord(paragraph: String, banned: Array[String]): String = paragraph
    .toLowerCase()
    .map(c => if (c.isLetter) c else ' ')
    .split("\\s+")
    .filterNot(banned.contains(_))
    .groupBy(identity)
    .mapValues(_.length).maxBy(_._2)._1
}
