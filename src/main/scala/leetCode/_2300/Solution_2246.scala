package leetCode._2300

import scala.collection.mutable

object Solution_2246 {
  def longestPath(parent: Array[Int], s: String): Int = {
    val childMap = mutable.Map.empty[Int, List[Int]].withDefaultValue(List.empty)
    parent.indices.foreach(i => childMap(parent(i)) ::= i)

    def f(nodeIndex: Int): (Int, Int) = {
      val nodeChar = s(nodeIndex)
      childMap.get(nodeIndex) match {
        case None => (1, 1)
        case Some(childIndices) =>
          val (closed, open) = childIndices.map(f).unzip
          val unitable = open.zip(childIndices).filter(pair => s(pair._2) != nodeChar).map(_._1).sorted.reverse
          (closed.max.max(unitable.take(2).sum + 1), unitable.take(1).sum + 1)
      }
    }

    f(0)._1
  }
}
