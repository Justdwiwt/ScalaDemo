package leetCode._3900

object Solution_3884 {
  def firstMatchingIndex(s: String): Int = s
    .zip(s.reverse)
    .zipWithIndex
    .filter(n => n._1._1 == n._1._2)
    .map(_._2)
    .headOption
    .getOrElse(-1)
}
