package leetCode._4000

object Solution_3931 {
  def isAdjacentDiffAtMostTwo(s: String): Boolean =
    !s.toList.zip(s.toList.tail).map(n => (n._2 - n._1).abs).exists(_ > 2)
}
