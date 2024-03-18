package leetCode._2300

object Solution_2225 {
  def findWinners(matches: Array[Array[Int]]): List[List[Int]] = List(
    matches
      .map(_.head)
      .toList
      .toSet
      .diff(matches.map(_(1)).toList.toSet)
      .toList
      .sorted,
    matches
      .map(_(1))
      .groupBy(identity)
      .mapValues(_.length)
      .filter(_._2 == 1)
      .keys
      .toList
      .sorted
  )
}
