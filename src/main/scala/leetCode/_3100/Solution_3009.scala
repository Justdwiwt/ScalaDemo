package leetCode._3100

import scala.collection.mutable

object Solution_3009 {
  def maxIntersectionCount(y: Array[Int]): Int = {
    // fixme: case 848/850 error
    val arr = mutable.ArrayBuffer[(Int, Int)]()

    y.indices.dropRight(1).foreach(i => {
      val left = y(i)
      val right = y(i + 1)
      if (left < right) {
        arr += ((2 * left, 1))
        arr += ((2 * right, -1))
      } else {
        arr += ((2 * right, 1))
        arr += ((2 * left, -1))
      }
    })

    var cnt = 0
    var maxCount = 0
    arr.sorted.foreach { case (_, delta) =>
      cnt += delta
      maxCount = maxCount.max(cnt)
    }

    maxCount
  }
}
