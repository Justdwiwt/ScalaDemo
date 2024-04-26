package leetCode._2000

import scala.collection.immutable.TreeMap

object Solution_1902 {
  def maxDepthBST(order: Array[Int]): Int = {
    val tm = TreeMap(0 -> 0, Integer.MAX_VALUE -> 0)
    order.foldLeft((tm, 0)) { case ((treeMap, maxDepth), i) =>
      val lower = treeMap.rangeImpl(Some(0), Some(i)).last
      val higher = treeMap.rangeImpl(Some(i), None).head
      val depth = lower._2.max(higher._2) + 1
      (treeMap.updated(i, depth), maxDepth.max(depth))
    }._2
  }
}
