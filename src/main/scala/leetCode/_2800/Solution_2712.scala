package leetCode._2800

object Solution_2712 {
  def minimumCost(s: String): Long = s
    .indices
    .drop(1)
    .filter(i => s(i) != s(i - 1))
    .map(i => i.min(s.length - i))
    .foldLeft(0L)(_ + _)
}
