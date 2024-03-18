package leetCode._3100

object Solution_3027 {
  def numberOfPairs(points: Array[Array[Int]]): Int =
    new CTPlacer(points).happyPairLocationsCount
}

private object CTPlacer {
  private object Point {
    def apply(arr: Array[Int]): Point = Point(arr.head, arr(1))
  }

  case class Point(x: Int, y: Int)

}

class CTPlacer(unsortedPoints: Array[Array[Int]]) {

  import CTPlacer._

  private lazy val points = unsortedPoints.map(Point(_)).sortBy(p => (p.x, -p.y))
  private lazy val n = points.length

  lazy val happyPairLocationsCount: Int = {
    points
      .indices
      .map { cIdx => val c = points(cIdx); (cIdx, c) }
      .map { case (cIdx, c) =>
        var maxTy = Int.MinValue
        var cnt = 0
        (cIdx + 1 until n)
          .map { tIdx => val t = points(tIdx); (tIdx, t) }
          .withFilter { case (_, t) => c.y >= t.y }
          .withFilter { case (_, t) => t.y > maxTy }
          .foreach { case (_, t) =>
            maxTy = t.y
            cnt += 1
          }
        cnt
      }
      .sum
  }
}
