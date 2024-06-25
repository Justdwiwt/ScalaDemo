package leetCode._1000

import scala.math.sqrt

object Solution_963 {
  private type Point = (Int, Int)
  private type Area = Double

  implicit class PointOps(val p: Point) extends AnyVal {
    def +(q: Point): Point = (p._1 + q._1, p._2 + q._2)

    def -(q: Point): Point = (p._1 - q._1, p._2 - q._2)
  }

  def minAreaFreeRect(points: Array[Array[Int]]): Area =
    minAreaFreeRect(points.map(arr => (arr.head, arr(1))))

  private def minAreaFreeRect(points: Array[Point]): Area = {
    val pointsSet = points.toSet

    val n = points.length

    val areas = points
      .indices
      .dropRight(2)
      .flatMap(aIdx => (aIdx + 1 until n - 1)
        .flatMap(bIdx => (bIdx + 1 until n)
          .flatMap(cIdx => find(points(aIdx), points(bIdx), points(cIdx))
            .withFilter(area => pointsSet.contains(area._1))
            .map(_._2)
          )))

    if (areas.nonEmpty) areas.min else 0
  }

  private def find(a: Point, b: Point, c: Point): Option[(Point, Area)] = {
    val ab2 = dist2(a, b)
    val bc2 = dist2(b, c)
    val ca2 = dist2(c, a)

    if (ab2 + bc2 == ca2) Some((a - b + c, sqrt(ab2.toDouble * bc2)))
    else if (bc2 + ca2 == ab2) Some((b - c + a, sqrt(bc2.toDouble * ca2)))
    else if (ca2 + ab2 == bc2) Some((c - a + b, sqrt(ca2.toDouble * ab2)))
    else None
  }

  private def dist2(a: Point, b: Point): Long =
    (a._1 - b._1).toLong * (a._1 - b._1) + (a._2 - b._2).toLong * (a._2 - b._2)
}
