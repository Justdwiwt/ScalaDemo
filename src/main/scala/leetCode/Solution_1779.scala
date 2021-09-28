package leetCode

object Solution_1779 {
  def nearestValidPoint(x: Int, y: Int, points: Array[Array[Int]]): Int = {
    val candidates = points
      .zip(points.indices)
      .filter(t => t._1.head == x || t._1(1) == y)
      .map(pts => ((x - pts._1.head).abs + (y - pts._1(1)).abs, pts._2))
      .sortWith((a, b) => a._2 < b._2)
      .sorted
    if (candidates.length > 0) candidates.head._2 else -1
  }
}
