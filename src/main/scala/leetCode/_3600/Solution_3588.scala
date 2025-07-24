package leetCode._3600

object Solution_3588 {
  def maxArea(coords: Array[Array[Int]]): Long = {
    def calc(j: Int): Long = {
      val grouped = coords.groupBy(_(j)).mapValues(_.map(_(1 - j)))
      val xs = grouped.keys.toArray.sorted
      if (xs.length <= 1) return 0L

      val minX = xs.head
      val maxX = xs.last

      grouped.map { case (x, ys) =>
        val minY = ys.min
        val maxY = ys.max
        val height = maxY - minY
        val width = (x - minX).max(maxX - x)
        height.toLong * width
      }.max
    }

    val res = calc(0).max(calc(1))
    if (res == 0L) -1L else res
  }
}
