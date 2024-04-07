package leetCode._300

object Solution_274 {
  def hIndex(citations: Array[Int]): Int = citations
    .sortWith(_ > _)
    .zipWithIndex
    .find { case (e, i) => e < i + 1 }
    .map(_._2)
    .getOrElse(citations.length)
}
