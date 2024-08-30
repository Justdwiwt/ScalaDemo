package leetCode._2700

object Solution_2699 {
  private val INF: Int = 0x3f3f3f3f

  def modifiedGraphEdges(n: Int, edges: Array[Array[Int]], source: Int, destination: Int, target: Int): Array[Array[Int]] = {
    val initGraph = initializeGraph(n, edges)
    val distance = dijkstra(n, source, initGraph)

    if (distance(destination) < target) Array.ofDim[Int](0, 0)
    else if (distance(destination) == target) edges.map(edge => if (edge(2) == -1) edge.updated(2, target + 1) else edge)
    else {
      val updatedEdges = adjustEdges(edges, n, destination, target, initGraph, source)
      updatedEdges.getOrElse(Array.ofDim[Int](0, 0))
    }
  }

  private def initializeGraph(n: Int, edges: Array[Array[Int]]): Array[Array[Int]] = {
    val graph = Array.fill(n, n)(INF)
    (0 until n).foreach(i => graph(i)(i) = 0)
    edges.foreach { case Array(u, v, w) =>
      if (w != -1) {
        graph(u)(v) = w
        graph(v)(u) = w
      }
    }
    graph
  }

  private def dijkstra(n: Int, src: Int, graph: Array[Array[Int]]): Array[Int] = {
    val distance = Array.fill(n)(INF).updated(src, 0)
    val selected = Array.fill(n)(false)

    def findMinIdx(selected: Array[Boolean], distance: Array[Int]): Int =
      (0 until n).filterNot(selected).minBy(distance)

    def relaxEdges(distance: Array[Int], graph: Array[Array[Int]], selected: Array[Boolean], target: Int): Array[Int] =
      (0 until n).foldLeft(distance)((dist, _) => {
        val targetIndex = findMinIdx(selected, dist)
        selected(targetIndex) = true
        (0 until n).foldLeft(dist)((d, j) => if (!selected(j)) d.updated(j, d(j).min(d(targetIndex) + graph(targetIndex)(j))) else d)
      })

    relaxEdges(distance, graph, selected, src)
  }

  private def adjustEdges(edges: Array[Array[Int]], n: Int, destination: Int, target: Int, initialGraph: Array[Array[Int]], source: Int): Option[Array[Array[Int]]] = {
    val list = edges.indices.filter(edges(_)(2) == -1)
    val resultEdges = list.foldLeft((false, edges, initialGraph)) {
      case ((found, currentEdges, graph), i) if !found =>
        val updatedEdge = currentEdges(i).updated(2, 1)
        val newGraph = updateGraph(graph, updatedEdge)
        val distance = dijkstra(n, source, newGraph)
        if (distance(destination) <= target) {
          val finalEdge = updatedEdge.updated(2, target - distance(destination) + 1)
          (true, currentEdges.updated(i, finalEdge), newGraph)
        } else (false, currentEdges.updated(i, updatedEdge), newGraph)
      case ((_, currentEdges, graph), i) => (true, currentEdges.updated(i, currentEdges(i).updated(2, target + 1)), graph)
    }

    if (resultEdges._1) Some(resultEdges._2) else None
  }

  private def updateGraph(graph: Array[Array[Int]], edge: Array[Int]): Array[Array[Int]] = {
    val Array(u, v, w) = edge
    val updatedGraph = graph.map(_.clone())
    updatedGraph(u)(v) = w
    updatedGraph(v)(u) = w
    updatedGraph
  }
}
