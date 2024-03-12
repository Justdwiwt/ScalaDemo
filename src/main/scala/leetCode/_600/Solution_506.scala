package leetCode._600

object Solution_506 {
  def findRelativeRanks(score: Array[Int]): Array[String] = score
    .zipWithIndex
    .sortBy(_._1)(Ordering.Int.reverse)
    .zipWithIndex.map({
    case ((_, idx), 0) => ("Gold Medal", idx)
    case ((_, idx), 1) => ("Silver Medal", idx)
    case ((_, idx), 2) => ("Bronze Medal", idx)
    case ((_, idx), rank) => ((rank + 1).toString, idx)
  })
    .sortBy(_._2)
    .map(_._1)
}
