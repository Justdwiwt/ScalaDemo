package leetCode._3200

import scala.collection.immutable.TreeMap

object Solution_3102 {
  def minimumDistance(points: Array[Array[Int]]): Int = {
    val xs = points.foldLeft(TreeMap.empty[Int, Int])((acc, p) => acc + ((p.head + p(1)) -> (acc.getOrElse(p.head + p(1), 0) + 1)))
    val ys = points.foldLeft(TreeMap.empty[Int, Int])((acc, p) => acc + ((p(1) - p.head) -> (acc.getOrElse(p(1) - p.head, 0) + 1)))

    def f(xs: TreeMap[Int, Int], ys: TreeMap[Int, Int], p: Array[Int], currentAns: Int): Int = {
      val x = p.head + p(1)
      val y = p(1) - p.head
      val updatedXs = if (xs(x) == 1) xs - x else xs.updated(x, xs(x) - 1)
      val updatedYs = if (ys(y) == 1) ys - y else ys.updated(y, ys(y) - 1)
      currentAns.min((updatedXs.lastKey - updatedXs.firstKey).max(updatedYs.lastKey - updatedYs.firstKey))
    }

    points.foldLeft(Integer.MAX_VALUE)((res, p) => f(xs, ys, p, res))
  }
}
