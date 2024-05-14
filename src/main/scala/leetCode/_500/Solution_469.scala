package leetCode._500

object Solution_469 {
  def isConvex(points: List[List[Int]]): Boolean = {
    val n = points.length
    val (_, isConvex) = points.indices.foldLeft((0L, true)) { case ((pre, isConvex), i) =>
      val cur = crossProduct(
        points((i + 1) % n).head - points(i).head,
        points((i + 1) % n)(1) - points(i)(1),
        points((i + 2) % n).head - points(i).head,
        points((i + 2) % n)(1) - points(i)(1)
      )
      if (cur != 0) {
        if (cur * pre < 0) (cur, false)
        else (cur, isConvex)
      } else (pre, isConvex)
    }
    isConvex
  }

  private def crossProduct(x1: Long, y1: Long, x2: Long, y2: Long): Long =
    x1 * y2 - x2 * y1
}
