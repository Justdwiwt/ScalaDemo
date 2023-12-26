package leetCode

object Solution_2965 {
  def findMissingAndRepeatedValues(grid: Array[Array[Int]]): Array[Int] =
    Array(grid.flatten.groupBy(identity).mapValues(_.length).filter(_._2 == 2).keys.head,
      Stream.from(1).take(grid.length * grid.head.length).toSet.diff(grid.flatten.toSet).head)
}
