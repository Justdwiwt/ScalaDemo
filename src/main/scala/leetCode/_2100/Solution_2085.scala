package leetCode._2100

object Solution_2085 {
  def countWords(words1: Array[String], words2: Array[String]): Int = {
    val words1Set = words1.groupBy(identity).mapValues(_.length).toArray.filter(_._2 == 1).map(_._1).toSet
    val words2Set = words2.groupBy(identity).mapValues(_.length).toArray.filter(_._2 == 1).map(_._1).toSet
    words1Set.intersect(words2Set).size
  }
}
