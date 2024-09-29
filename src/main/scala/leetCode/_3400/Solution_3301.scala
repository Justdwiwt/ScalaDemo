package leetCode._3400

object Solution_3301 {
  def maximumTotalSum(maximumHeight: Array[Int]): Long = {
    val sorted = maximumHeight.sorted(Ordering[Int].reverse)

    @annotation.tailrec
    def adjustHeights(heights: Array[Int], idx: Int): Array[Int] =
      if (idx >= heights.length) heights
      else {
        val newHeight = Math.min(heights(idx), heights(idx - 1) - 1)
        if (newHeight <= 0) return Array(-1)
        heights(idx) = newHeight
        adjustHeights(heights, idx + 1)
      }

    val res = adjustHeights(sorted, 1)
    if (res.contains(-1)) -1 else res.map(_.toLong).sum
  }
}
