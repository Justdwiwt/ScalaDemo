package leetCode.offer

object Offer_106 {
  def isBipartite(graph: Array[Array[Int]]): Boolean = {
    val colors = collection.mutable.Map.empty[Int, Int]

    def dye(vertex: Int, color: Int, neighbours: Array[Int]): Boolean = colors
      .get(vertex)
      .map(_ == color)
      .getOrElse({
        colors(vertex) = color
        neighbours.forall(n => dye(n, 1 - color, graph(n)))
      })

    graph.indices.forall(vertex => colors.get(vertex).fold(dye(vertex, 0, graph(vertex)))(_ => true))
  }
}
