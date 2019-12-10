package leetCode

import scala.collection.mutable
import scala.util.control.Breaks._

object Solution_587 {
  def outerTrees(points: Array[Array[Int]]): Array[Array[Int]] = {
    if (points.length == 1) return points
    var curX = Int.MaxValue
    var curY = 0
    points.foreach(i => if (i(0) <= curX) {
      curX = i(0)
      curY = i(1)
    })
    var vecX = 0
    var vecY = 1
    var res = Array.empty[Array[Int]]
    val added = new mutable.HashMap[Int, mutable.HashSet[Int]]()
    added.put(curX, mutable.HashSet.empty)
    res :+= Array(curX, curY)
    added(curX).add(curY)
    breakable {
      while (true) {
        var nextX = 0
        var nextY = 0
        var cosMx = -Float.MaxValue
        var lenMn = Int.MaxValue.toLong
        points.foreach(i => {
          breakable {
            if (i(0) == curX && i(1) == curY) break
          }
          val vX = i(0) - curX
          val vY = i(1) - curY
          val vLen = vX * vX + vY * vY
          val cos = (vecX * vX + vecY * vY) / (math.sqrt(vecX * vecX + vecY * vecY) * math.sqrt(vLen)).toFloat
          if ((cos > cosMx) || (cos == cosMx && lenMn > vLen)) {
            nextX = i(0)
            nextY = i(1)
            lenMn = vLen
            cosMx = cos
          }
        })
        if (added.contains(nextX) && added(nextX).contains(nextY)) break
        else {
          vecX = nextX - curX
          vecY = nextY - curY
          curX = nextX
          curY = nextY
          res :+= Array(curX, curY)
        }
      }
    }
    res
  }
}
