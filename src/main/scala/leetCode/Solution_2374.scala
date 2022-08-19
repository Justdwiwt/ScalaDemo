package leetCode

import scala.collection.mutable

object Solution_2374 {
  def edgeScore(edges: Array[Int]): Int = {
    val m = mutable.Map.empty[Int, Long].withDefaultValue(0)
    edges.zipWithIndex.foreach { case (node, idx) => m(node) -= idx }
    m.toList.map(_.swap).min._2
  }
}
