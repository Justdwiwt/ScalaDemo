package leetCode

object Solution_2279 {
  def maximumBags(capacity: Array[Int], rocks: Array[Int], additionalRocks: Int): Int = capacity
    .indices
    .sortBy(i => capacity(i) - rocks(i))
    .iterator
    .scanLeft(additionalRocks) { case (additionalRocks, i) => additionalRocks - (capacity(i) - rocks(i)) }
    .drop(1)
    .takeWhile(_ >= 0)
    .size
}
