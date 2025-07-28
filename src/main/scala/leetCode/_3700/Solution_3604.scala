package leetCode._3700

import scala.collection.immutable.SortedSet

object Solution_3604 {
  def minTime(n: Int, edgeArray: Array[Array[Int]]): Int = {
    case class Edge(node: Int, start: Int, end: Int)
    case class State(time: Int, node: Int)

    implicit val ordering: Ordering[State] = Ordering.by(s => (s.time, s.node))

    val grouped: Map[Int, Array[Edge]] = edgeArray
      .groupBy(_.head)
      .map { case (k, edges) => k -> edges.map { case Array(_, v, start, end) => Edge(v, start, end) } }
      .withDefault(_ => Array.empty[Edge])

    @scala.annotation.tailrec
    def search(states: SortedSet[State], nodeToMinTime: Map[Int, Int]): Int = {
      if (states.isEmpty) -1
      else {
        val State(time, u) = states.head
        if (u == n - 1) time
        else if (nodeToMinTime.get(u).forall(time < _)) {
          val nextStates = grouped(u).iterator.collect {
            case Edge(v, start, end) if time <= end =>
              State(time.max(start) + 1, v)
          }
          search(states.tail ++ nextStates, nodeToMinTime.updated(u, time))
        } else search(states.tail, nodeToMinTime)
      }
    }

    search(SortedSet(State(0, 0)), Map())
  }
}
