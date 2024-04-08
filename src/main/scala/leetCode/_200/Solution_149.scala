package leetCode._200

object Solution_149 {
  def maxPoints(points: Array[Array[Int]]): Int = {
    def slope(i: Int, j: Int): Double = {
      val (Array(x0, y0), Array(x1, y1)) = (points(i), points(j))
      if (y0 == y1) Int.MaxValue else (x0 - x1) * 1.0 / (y0 - y1)
    }

    points
      .indices
      .dropRight(1)
      .foldLeft(0)((globalMax, i) => (i + 1 until points.length)
        .groupBy(slope(i, _))
        .mapValues(_.size)
        .values
        .reduceOption(_.max(_))
        .getOrElse(0)
        .max(globalMax)
      ) + 1
  }
}
