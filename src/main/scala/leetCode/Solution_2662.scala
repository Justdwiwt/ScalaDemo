package leetCode

import scala.collection.mutable

object Solution_2662 {
  def minimumCost(start: Array[Int], target: Array[Int], specialRoads: Array[Array[Int]]): Int = {
    val startPos = (start.head << 32 | start(1)).toLong
    val endPos = (target.head << 32 | target(1)).toLong
    if (startPos == endPos) return 0
    val disMap = mutable.HashMap.empty[Long, Int]
    disMap += startPos -> 0
    disMap += endPos -> Int.MaxValue
    val visited = mutable.HashSet.empty[Long]
    while (true) {
      var startPoint = -1L
      var minDis = -1
      disMap.foreach(e => {
        if (!visited.contains(e._1) && (startPoint < 0 || minDis > e._2)) {
          startPoint = e._1
          minDis = e._2
        }
      })
      visited += startPoint
      if (startPoint == endPos) return disMap(endPos)
      val x = (startPoint >> 32).toInt
      val y = startPoint.toInt & Int.MaxValue
      disMap += endPos -> (minDis + (x - target.head).abs + (y - target(1)).abs).min(disMap(endPos))
      specialRoads.foreach(road => {
        val disOne = (road.head - x).abs + (road(1) - y).abs + road(4) + minDis
        val disTwo = (road(2) - x).abs + (road(3) - y).abs + minDis
        val min = disOne.min(disTwo)
        val point = (road(2) << 32 | road(3)).toLong
        disMap += point -> min.min(disMap.getOrElse(point, Int.MaxValue))
      })
    }
    -1
  }
}
