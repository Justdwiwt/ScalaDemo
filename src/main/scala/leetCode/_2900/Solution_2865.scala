package leetCode._2900

object Solution_2865 {
  def maximumSumOfHeights(maxHeights: List[Int]): Long =
    f(Nil, maxHeights, 0)

  @scala.annotation.tailrec
  private def f(left: List[Int], right: List[Int], max: Long): Long = right match {
    case Nil => max
    case height :: tail =>
      val sums = g(height, left) + g(height, tail) + height
      f(height :: left, tail, max.max(sums))
  }

  private def g(init: Int, heights: List[Int]): Long = heights./:((0L, init)) { case ((sum, prev), height) =>
    val min = prev.min(height)
    (sum + min, min)
  }._1
}
