package leetCode._3400

object Solution_3380 {
  def maxRectangleArea(points: Array[Array[Int]]): Int = {
    val pointSet = points.map(p => (p.head, p(1))).toSet
    points.indices.flatMap(i => {
      (i + 1 until points.length).flatMap(j => {
        val (x1, y1) = (points(i).head, points(i)(1))
        val (x2, y2) = (points(j).head, points(j)(1))
        if (x1 != x2 && y1 != y2) {
          val (x3, y3) = (x1, y2)
          val (x4, y4) = (x2, y1)
          if (pointSet.contains((x3, y3)) && pointSet.contains((x4, y4))) {
            val area = ((x2 - x1) * (y2 - y1)).abs
            val allInsidePoints = pointSet.exists {
              case (x, y) =>
                (x > x1.min(x2) && x < x1.max(x2) && y >= y1.min(y2) && y <= y1.max(y2)) ||
                  (y > y1.min(y2) && y < y1.max(y2) && x >= x1.min(x2) && x <= x1.max(x2))
            }
            if (!allInsidePoints) Some(area) else None
          } else None
        } else None
      })
    }).foldLeft(-1)(math.max)
  }
}
