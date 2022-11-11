package leetCode

object Solution_2225 {
  def findWinners(matches: Array[Array[Int]]): List[List[Int]] = List(
    matches
      .map(n => n.head)
      .toList
      .toSet
      .diff(matches.map(n => n(1)).toList.toSet)
      .toList
      .sorted,
    matches
      .map(n => n(1))
      .groupBy(identity)
      .mapValues(_.length)
      .filter(_._2 == 1)
      .keys
      .toList
      .sorted
  )
}
