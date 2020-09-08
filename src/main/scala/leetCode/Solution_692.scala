package leetCode

object Solution_692 {
  def topKFrequent(words: Array[String], k: Int): List[String] = {
    words.groupBy(identity).mapValues(_.length).toSeq.sortBy(x => (-x._2, x._1)).take(k).map(_._1).toList
  }
}
