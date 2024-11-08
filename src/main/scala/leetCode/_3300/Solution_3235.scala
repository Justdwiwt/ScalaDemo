package leetCode._3300

object Solution_3235 {
  def canReachCorner(xCorner: Int, yCorner: Int, circles: Array[Array[Int]]): Boolean = {
    val visited = Array.fill(circles.length)(false)

    def pointInCircle(px: Long, py: Long, x: Long, y: Long, r: Long): Boolean =
      (x - px) * (x - px) + (y - py) * (y - py) <= r * r

    def circleIntersectsTopLeftOfRectangle(x: Int, y: Int, r: Int, xCorner: Int, yCorner: Int): Boolean =
      (x.abs <= r && 0 <= y && y <= yCorner) ||
        (0 <= x && x <= xCorner && (y - yCorner).abs <= r) ||
        pointInCircle(x, y, 0, yCorner, r)

    def circleIntersectsBottomRightOfRectangle(x: Int, y: Int, r: Int, xCorner: Int, yCorner: Int): Boolean = {
      (y.abs <= r && 0 <= x && x <= xCorner) ||
        (0 <= y && y <= yCorner && (x - xCorner).abs <= r) ||
        pointInCircle(x, y, xCorner, 0, r)
    }

    def circlesIntersectInRectangle(x1: Long, y1: Long, r1: Long, x2: Long, y2: Long, r2: Long, xCorner: Long, yCorner: Long): Boolean = {
      (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) <= (r1 + r2) * (r1 + r2) &&
        x1 * r2 + x2 * r1 < (r1 + r2) * xCorner &&
        y1 * r2 + y2 * r1 < (r1 + r2) * yCorner
    }

    def dfs(i: Int): Boolean = {
      val Array(x1, y1, r1) = circles(i)
      if (circleIntersectsBottomRightOfRectangle(x1, y1, r1, xCorner, yCorner)) true
      else {
        visited(i) = true
        circles.indices.exists(j => {
          val Array(x2, y2, r2) = circles(j)
          !visited(j) && circlesIntersectInRectangle(x1, y1, r1, x2, y2, r2, xCorner, yCorner) && dfs(j)
        })
      }
    }

    !circles.indices.exists { i =>
      val Array(x, y, r) = circles(i)
      pointInCircle(0, 0, x, y, r) || pointInCircle(xCorner, yCorner, x, y, r) ||
        (!visited(i) && circleIntersectsTopLeftOfRectangle(x, y, r, xCorner, yCorner) && dfs(i))
    }
  }
}
