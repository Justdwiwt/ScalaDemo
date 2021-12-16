package leetCode

object Solution_1971 {
  def validPath(n: Int, edges: Array[Array[Int]], start: Int, end: Int): Boolean =
    bfs(diffGraph(n, edges), start, end)

  def diffGraph(n: Int, edges: Array[Array[Int]]): Map[Int, List[Int]] = {
    var mapNodes = (0 until n).map(node => node -> List.empty[Int]).toMap
    edges.foreach(e => {
      val s = e.head
      val f = e(1)
      mapNodes = mapNodes + (s -> (f :: mapNodes(s)))
      mapNodes = mapNodes + (f -> (s :: mapNodes(f)))
    })
    mapNodes
  }

  def bfs(graph: Map[Int, List[Int]], start: Int, end: Int): Boolean = {
    if (start == end) return true
    var visited = Set(start)
    var nodes = List(start)
    while (nodes.nonEmpty) {
      val neighbours = nodes.flatMap(graph).filter(!visited.contains(_))
      visited = visited ++ neighbours
      neighbours.foreach(e => if (e == end) return true)
      nodes = neighbours
    }
    false
  }
}
