package leetCode

object Solution_1051 {
  def heightChecker(heights: Array[Int]): Int = heights.zip(heights.sorted).count({ case (x, y) => x != y })
}
