package leetCode._2700

import scala.collection.mutable

object Solution_2685 {
  def countCompleteComponents(n: Int, edges: Array[Array[Int]]): Int = {
    val collected = edges.collect { case Array(v1, v2) => (v1, v2) }
    val dest = collected.foldLeft(Map.empty[Int, List[Int]].withDefaultValue(List.empty)) { case (map, (v1, v2)) =>
      map.updated(v1, v2 :: map(v1)).updated(v2, v1 :: map(v2))
    }
    (0 until n).foldLeft((Set.empty[Int], 0)) { case (st@(visited, cnt), v) =>
      if (visited.contains(v)) st
      else {
        val component = f(v, dest)
        val nCnt = if (component.forall(dest(_).size == component.size - 1)) cnt + 1 else cnt
        (visited ++ component, nCnt)
      }
    }._2
  }

  private def f(init: Int, dest: Map[Int, List[Int]]): Vector[Int] = {
    val visit = mutable.Stack(init)
    val visited = mutable.Set.empty[Int]
    while (visit.nonEmpty) {
      val v = visit.pop()
      if (visited.add(v)) visit.pushAll(dest(v))
    }
    visited.toVector
  }
}
