package leetCode

object Solution_56 {
  def merge(intervals: Array[Array[Int]]): Array[Array[Int]] = intervals
    .sortBy(_.head)
    ./:(Vector[Array[Int]]()) { case (acc, cur) =>
      acc.headOption match {
        case Some(last) if last(1) >= cur.head => Array(last.head, cur(1).max(last(1))) +: acc.tail
        case _ => cur +: acc
      }
    }.reverse.toArray
}
