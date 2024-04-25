package leetCode._2100

import scala.collection.mutable.ArrayBuffer

object Solution_2015 {
  def averageHeightOfBuildings(buildings: Array[Array[Int]]): Array[Array[Int]] = {
    val points = ArrayBuffer.empty[(Int, Int, Int)]

    buildings
      .withFilter { case Array(_, _, _) => true; case _ => false }
      .foreach { case Array(x, y, h) =>
        points += ((x, 1, h))
        points += ((y, -1, h))
      }

    val sorted = points.sortBy(_._1)
    val res = ArrayBuffer.empty[Array[Int]]
    var cur = 0
    var s = 0
    var c = 0

    while (sorted.nonEmpty) {
      val (num, kind, height) = sorted.remove(sorted.length - 1)
      if (c != 0 && num != cur) {
        if (res.nonEmpty && res.last.head == cur && s / c == res.last(2)) res.last(0) = num
        else res += Array(num, cur, s / c)
      }
      s += height * kind * -1
      c += kind * -1
      cur = num
    }

    res.toArray
  }
}
