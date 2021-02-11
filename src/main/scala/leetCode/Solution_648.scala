package leetCode

object Solution_648 {
  def replaceWords(dict: List[String], sentence: String): String = sentence
    .split(" ")
    .map(str => dict
      .toArray
      .sortBy(_.length)
      .dropWhile(word => !str.startsWith(word))
      .headOption match {
      case None => str
      case Some(v) => v
    }).reduce(_ + " " + _)
}
