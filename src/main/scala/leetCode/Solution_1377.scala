package leetCode

object Solution_1377 {
  //  def frogPosition(n: Int, edges: Array[Array[Int]], t: Int, target: Int): Double =
  //    frogPosition(Edges(edges), t, target)
  //
  //  def frogPosition(edges: Edges, time: Int, target: Int): Double = {
  //    def dfs(vertex: Int, time: Int, probability: Double, visited: Set[Int]): Double = {
  //      val neighbors = edges.neighbors(vertex).filterNot(visited.contains)
  //      if (time == 0 || neighbors.isEmpty) {
  //        if (vertex == target) probability
  //        else 0.0
  //      } else {
  //        LazyList(neighbors: _*)
  //          .map(dfs(_, time - 1, probability / neighbors.length, visited + vertex))
  //          .find(_ > 0.0)
  //          .getOrElse(0.0)
  //      }
  //    }
  //
  //    dfs(1, time, 1.0, Set())
  //  }
  //
  //  final class Edges(map: Map[Int, Array[Int]]) {
  //    def neighbors(u: Int): Array[Int] = map.getOrElse(u, Array())
  //  }
  //
  //  object Edges {
  //    def apply(edges: Array[Array[Int]]): Edges = new Edges(edges
  //      .flatMap {
  //        case Array(u, v) => Iterable(u -> v, v -> u)
  //        case _ => None
  //      }
  //      .groupMap(_._1)(_._2))
  //  }
}
