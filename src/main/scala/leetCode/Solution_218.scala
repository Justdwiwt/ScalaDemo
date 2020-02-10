package leetCode

import scala.collection.mutable

object Solution_218 {
  def getSkyline(buildings: Array[Array[Int]]): List[(Int, Int)] = {
    var res = List.empty[(Int, Int)]
    var cur = 0
    var curX = 0
    var curH = -1
    val aliveBuilds = new mutable.PriorityQueue[(Int, Int)]()
    while (cur < buildings.length || aliveBuilds.nonEmpty) {
      curX = if (aliveBuilds.isEmpty) buildings(cur)(0) else aliveBuilds.head._2
      if (cur >= buildings.length || buildings(cur)(0) > curX)
        while (aliveBuilds.nonEmpty && (aliveBuilds.head._2 <= curX)) aliveBuilds.dequeue()
      else {
        curX = buildings(cur)(0)
        while (cur < buildings.length && buildings(cur)(0) == curX) {
          aliveBuilds.enqueue((buildings(cur)(2), buildings(cur)(1)))
          cur += 1
        }
      }
      curH = if (aliveBuilds.isEmpty) 0 else aliveBuilds.head._1
      if (res.isEmpty || (res.last._2 != curH)) res :+= (curX, curH)
    }
    res
  }
}
