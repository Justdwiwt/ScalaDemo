package leetCode._2700

import scala.collection.mutable

object Solution_2642 {
  class Graph(_n: Int, _edges: Array[Array[Int]]) {


    private val edgeMap = mutable.Map.empty[Int, List[(Int, Int)]].withDefaultValue(List.empty)
    _edges.foreach(addEdge)

    private def addEdge(arr: Array[Int]): Unit =
      edgeMap(arr(0)) ::= (arr(1), arr(2))

    def shortestPath(node1: Int, node2: Int): Int = {
      val visited = mutable.Set.empty[Int]
      val queue = mutable.PriorityQueue((0, node1)).reverse

      @scala.annotation.tailrec
      def f: Int =
        if (queue.isEmpty) -1
        else {
          val (cost, vertex) = queue.dequeue()
          if (!visited.add(vertex)) f
          else if (vertex == node2) cost
          else {
            edgeMap(vertex).foreach { case (to, edgeCost) => queue.enqueue((cost + edgeCost, to)) }
            f
          }
        }

      f
    }
  }

}
