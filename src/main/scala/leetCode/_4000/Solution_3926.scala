package leetCode._4000

object Solution_3926 {
  def countWordOccurrences(chunks: Array[String], queries: Array[String]): Array[Int] = {
    val cnt = "(?!--)[^-\\s]+(?:-(?!--)[^-\\s]+)*"
      .r
      .findAllIn(chunks.mkString)
      .toSeq
      .groupBy(identity)
      .mapValues(_.size)

    queries.map(cnt.getOrElse(_, 0))
  }
}
