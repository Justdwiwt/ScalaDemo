package leetCode._1700

import scala.collection.mutable
import scala.math.{pow, sqrt}

object Solution_1620 {
  def bestCoordinate(towers: Array[Array[Int]], radius: Int): Array[Int] = {
    var q: Int = 0

    def getDistance(t: Array[Int], point: (Int, Int)): Double =
      sqrt(pow(t(0) - point._1, 2) + pow(t(1) - point._2, 2))

    def getQuality(pointQuality: Int, d: Double): Int =
      if (pointQuality == 0 || d > radius) 0
      else (pointQuality / (1 + d)).toInt

    val minX = towers.map(x => x.head).min
    val maxX = towers.map(x => x.head).max
    val minY = towers.map(x => x.tail.head).min
    val maxY = towers.map(x => x.tail.head).max
    val maxQ = Array(0)
    val table = mutable.Map.empty[(Int, Int), Int]

    (minX to maxX).withFilter(i => i >= 0).foreach(i =>
      (minY to maxY).withFilter(j => j >= 0).foreach(j => {
        q = 0
        towers.foreach(k => q += getQuality(k.last, getDistance(k, (i, j))))
        if (q >= maxQ(0)) {
          maxQ(0) = q
          table += ((i, j) -> q)
        }
      })
    )
    val res = table.collect { case ((key1, key2), max) if max == maxQ.head => ((key1, key2), max) }.keys.min
    if (maxQ.head == 0) Array(0, 0) else Array(res._1, res._2)
  }
}
