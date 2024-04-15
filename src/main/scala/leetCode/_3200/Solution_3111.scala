package leetCode._3200

object Solution_3111 {
  def minRectanglesToCoverPoints(points: Array[Array[Int]], w: Int): Int = points
    .sortBy(_.head)
    .foldLeft(-1, 0) { case ((x2, cnt), point) =>
      val x = point.head
      if (x > x2) (x + w, cnt + 1) else (x2, cnt)
    }
    ._2
}
