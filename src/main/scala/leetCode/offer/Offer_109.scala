package leetCode.offer

import scala.collection.mutable

object Offer_109 {
  def openLock(deadends: Array[String], target: String): Int = {
    val q = new mutable.Queue[(String, Int)]
    q += ("0000" -> 0)
    val s = deadends.toSet
    val vis = collection.mutable.Set[String]("0000")
    while (q.nonEmpty) {
      val (node, depth) = q.dequeue
      if (node.equals(target)) return depth
      if (!s.contains(node))
        (0 to 3).foreach(i => (-1 to 1 by 2).foreach(j => {
          val t = ((node(i) - '0') + j + 10) % 10
          val newNode = node.substring(0, i) + t + node.substring(i + 1)
          if (!vis.contains(newNode)) {
            vis += newNode
            q += (newNode -> (depth + 1))
          }
        }))
    }
    -1
  }
}
