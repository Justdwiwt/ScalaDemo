package leetCode._200

object Solution_187 {
  def findRepeatedDnaSequences(s: String): List[String] = s
    .sliding(10)
    .toList
    .groupBy(identity)
    .mapValues(_.size)
    .filter(_._2 > 1)
    .keys
    .toList
}
