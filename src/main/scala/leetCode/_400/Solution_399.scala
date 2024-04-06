package leetCode._400

import scala.collection.immutable.Queue

object Solution_399 {
  def calcEquation(equations: List[List[String]], values: Array[Double], queries: List[List[String]]): Array[Double] = {
    lazy val graph = equations
      .zip(values)
      .flatMap { case (l, v) => List(l.head -> (l(1), v), l(1) -> (l.head, 1.0 / v)) }
      .groupBy(_._1)
      .mapValues(_.map(_._2))

    queries
      .map(l => l.head -> l(1))
      .map { case (src, tgt) =>
        @scala.annotation.tailrec
        def f(q: Queue[(String, Double)], visited: Set[String]): Double = {
          lazy val ((name: String, value: Double), q1) = q.dequeue
          lazy val nxt = graph.getOrElse(name, Nil).collect { case kv if !visited.contains(kv._1) => kv._1 -> kv._2 * value }
          if (q.isEmpty) -1.0
          else if (name == tgt) value
          else if (visited contains name) f(q1, visited)
          else f(q1 ++ nxt, visited + name)
        }

        if (!graph.contains(src)) -1.0
        else if (src == tgt) 1.0
        else f(Queue(src -> 1.0), Set())
      }
      .toArray
  }
}
