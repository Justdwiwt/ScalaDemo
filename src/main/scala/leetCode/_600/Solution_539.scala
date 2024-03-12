package leetCode._600

object Solution_539 {
  def findMinDifference(timePoints: List[String]): Int = {
    val sorted = timePoints.sorted.map(s => (s.take(2).toInt, s.takeRight(2).toInt))
    (sorted.zip(sorted.tail) :+ (sorted.head, sorted.last)).map({ case ((h1, m1), (h2, m2)) =>
      val x = (h2 - h1) * 60 + m2 - m1
      x.min(1440 - x)
    }).min
  }
}
