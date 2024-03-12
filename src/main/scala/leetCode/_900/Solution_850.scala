package leetCode._900

import scala.collection.mutable

object Solution_850 {
  def rectangleArea(rectangles: Array[Array[Int]]): Int = {
    var res = 0L
    val M = 1000000007L
    val sorted = rectangles.sortWith(_ (1) < _ (1))
    val ts = mutable.TreeSet.empty[Int]
    sorted.foreach(r => {
      ts += r.head
      ts += r(2)
    })
    val arr = ts.toArray
    arr.indices.dropRight(1).foreach(i => {
      val left = arr(i).toLong
      val right = arr(i + 1).toLong
      var bottom = 0
      var top = 0
      sorted.foreach(r => {
        if (r.head <= left && r(2) >= right) {
          res += (r(3) - r(1)) * (right - left)
          if (r(1) <= top) {
            res -= (r(3).min(top) - r(1)) * (right - left)
            top = top.max(r(3))
          } else {
            bottom = r(1)
            top = r(3)
          }
        }
      })
    })
    (res % M).toInt
  }
}
