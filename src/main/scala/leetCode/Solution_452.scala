package leetCode

object Solution_452 {
  def findMinArrowShots(points: Array[Array[Int]]): Int = {
    points.sortBy(_.head)./:((Int.MinValue, 0)) { case ((pre, cnt), p) =>
      if (p.head > pre || cnt == 0) (p(1), cnt + 1) else (pre.min(p(1)), cnt)
    }._2
  }
}
