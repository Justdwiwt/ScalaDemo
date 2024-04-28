package leetCode._1700

object Solution_1698 {
  def countDistinct(s: String): Int = s
    .indices
    .flatMap(i => (i + 1 to s.length).map(s.substring(i, _)))
    .toSet
    .size
}
