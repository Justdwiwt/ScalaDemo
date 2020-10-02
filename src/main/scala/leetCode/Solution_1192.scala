package leetCode

import scala.collection.mutable

object Solution_1192 {
  def criticalConnections(n: Int, connections: List[List[Int]]): List[List[Int]] = {
    val graph = mutable.Map[Int, List[Int]]()
    (0 to n).foreach(i => graph += i -> List[Int]())
    connections.foreach(c => {
      graph(c.head) = graph(c.head) :+ c(1)
      graph(c(1)) = graph(c(1)) :+ c.head
    })

    var id = 0
    val visited = Array.ofDim[Boolean](n)
    val ids = Array.ofDim[Int](n)
    val low = Array.ofDim[Int](n)
    var bridges = List[List[Int]]()

    def dfs(at: Int, parent: Int): Unit = {
      visited(at) = true
      id += 1
      ids(at) = id
      low(at) = ids(at)

      graph.getOrElse(at, List()).foreach(to => if (parent != to) {
        if (!visited(to)) {
          dfs(to, at)
          low(at) = low(at).min(low(to))
          if (ids(at) < low(to)) bridges = List(at, to) :: bridges
        } else low(at) = ids(to).min(low(at))
      })
    }

    (0 until n).foreach(i => if (!visited(i)) dfs(i, -1))
    bridges
  }
}
