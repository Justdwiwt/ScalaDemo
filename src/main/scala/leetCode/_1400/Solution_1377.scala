package leetCode._1400

import scala.collection.mutable

object Solution_1377 {
  def frogPosition(n: Int, edges: Array[Array[Int]], t: Int, target: Int): Double = {
    val m = mutable.Map.empty[Int, Set[Int]]
    edges.foreach { case Array(a, b) =>
      m += a -> (m.getOrElse(a, Set.empty) + b)
      m += b -> (m.getOrElse(b, Set.empty) + a)
    }

    def dfs(probability: Double, jumps: Int, vertex: Int, prev: Int): Double = {
      lazy val next = m.getOrElse(vertex, Set.empty) - prev
      if (prev == vertex) 0
      else if (next.nonEmpty && jumps > 0) next.map(dfs(probability / next.size, jumps - 1, _, vertex)).sum
      else if (vertex == target) probability
      else 0
    }

    dfs(1, t, 1, 0)
  }
}
