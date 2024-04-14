package leetCode.LCP

import scala.collection.mutable

object LCP_74 {
  def fieldOfGreatestBlessing(forceField: Array[Array[Int]]): Int = {
    val arr = forceField.map { case Array(x, y, side) => Array(x * 2L, y * 2L, side.toLong) }
    val buff = arr.flatMap { case Array(_, y, side) => List(y - side, y + side) }.sorted
    var res = 0
    buff.foreach(y => {
      val couMap = mutable.Map.empty[Long, Int]
      val couMap2 = mutable.Map.empty[Long, Int]

      forceField.indices.foreach(i => {
        val yTop = arr(i)(1) + arr(i)(2)
        val yDown = arr(i)(1) - arr(i)(2)

        if (y >= yDown && y <= yTop) {
          val xLeft = arr(i).head - arr(i)(2)
          val xRight = arr(i).head + arr(i)(2)
          couMap(xLeft) = couMap.getOrElse(xLeft, 0) + 1
          couMap2(xRight) = couMap2.getOrElse(xRight, 0) + 1
        }
      })

      val sorted = (couMap.keys ++ couMap2.keys).toList.sorted

      val (_, maxCount) = sorted.foldLeft((0, 0)) { case ((current, max), xi) =>
        val newCurrent = current + couMap.getOrElse(xi, 0)
        val newMax = max.max(newCurrent)
        (newCurrent - couMap2.getOrElse(xi, 0), newMax)
      }
      res = res.max(maxCount)
    })

    res
  }
}
