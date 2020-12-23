package leetCode

object Solution_387 {
  def firstUniqChar(s: String): Int = s
    .toList
    .zipWithIndex
    .groupBy(_._1)
    .map({ case (l, t) => (l, t.map(_._2)) })
    .filter(_._2.size == 1)
    .toList
    .sortBy(_._2.head)
    .headOption
    .map(_._2.head)
    .getOrElse(-1)
}
