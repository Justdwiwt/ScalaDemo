package leetCode

object Solution_2275 {
  def largestCombination(candidates: Array[Int]): Int = (0 until 24)
    .map(bit => candidates.count(c => (c >> bit & 1) == 1))
    .max
}
