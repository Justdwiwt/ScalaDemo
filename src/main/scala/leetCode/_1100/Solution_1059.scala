package leetCode._1100

import scala.collection.mutable

object Solution_1059 {
  def leadsToDestination(n: Int, edges: Array[Array[Int]], source: Int, destination: Int): Boolean = {
    val graph = Array.fill[List[Int]](n)(Nil)
    val hasVisitedDot = Array.fill[Boolean](n)(false)
    val memory = mutable.HashSet.empty[Int]

    edges.foreach(edge => {
      val x = edge.head
      val y = edge(1)
      graph(x) ::= y
    })

    def dfsPath(current: Int): Boolean =
      if (current == destination || memory.contains(current)) true
      else {
        val nextList = graph(current)
        if (nextList.isEmpty) false
        else {
          val noCycle = nextList.forall(next => {
            if (hasVisitedDot(next)) false
            else {
              hasVisitedDot(next) = true
              val result = dfsPath(next)
              hasVisitedDot(next) = false
              result
            }
          })
          if (noCycle) memory += current
          noCycle
        }
      }

    if (graph(destination).nonEmpty) false
    else {
      hasVisitedDot(source) = true
      dfsPath(source)
    }
  }
}
