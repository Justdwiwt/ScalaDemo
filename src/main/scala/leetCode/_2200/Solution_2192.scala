package leetCode._2200

import scala.collection.immutable.TreeSet
import scala.collection.mutable

object Solution_2192 {
  def getAncestors(n: Int, edges: Array[Array[Int]]): List[List[Int]] = {
    val ts = edges./:(Map.empty[Int, TreeSet[Int]].withDefaultValue(TreeSet.empty[Int])) {
      case (t, Array(from, to)) => t.updated(to, t(to) + from)
    }

    val m = mutable.Map.empty[Int, TreeSet[Int]]

    def f(node: Int): TreeSet[Int] = m.getOrElseUpdate(node, {
      if (ts(node).isEmpty) TreeSet.empty
      else ts(node).flatMap(x => f(x) + x)
    })

    (0 until n).map(f(_).toList).toList
  }
}
