package leetCode._1000

import scala.collection.mutable

object Solution_939 {
  def minAreaRect(points: Array[Array[Int]]): Int = {
    val m = mutable.HashMap.empty[Int, mutable.HashSet[Int]]

    points.foreach(point => {
      if (!m.contains(point.head)) m += point.head -> mutable.HashSet.empty[Int]
      m(point.head) += point(1)
    })

    val xLines = m.filter({ case (_, value) => value.size > 1 }).toList

    var res = Int.MaxValue

    xLines.indices.foreach(i => (i + 1 until xLines.size).foreach(j => {
      val (x1, ys1) = xLines(i)
      val (x2, ys2) = xLines(j)
      val common = ys1.intersect(ys2)
      if (common.size > 1) {
        val list = common.toList.sorted
        list.indices.drop(1).foreach(k => res = res.min((x1 - x2).abs * (list(k) - list(k - 1))))
      }
    }))

    if (res == Int.MaxValue) 0 else res
  }
}
