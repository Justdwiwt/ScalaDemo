package leetCode._3200

object Solution_3146 {
  def findPermutationDifference(s: String, t: String): Int = t
    .zipWithIndex
    .map { case (ch, idx) => (idx - s.zipWithIndex.toMap.getOrElse(ch, -1)).abs }
    .sum
}
