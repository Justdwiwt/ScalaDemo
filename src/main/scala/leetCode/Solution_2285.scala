package leetCode

object Solution_2285 {
  def maximumImportance(n: Int, roads: Array[Array[Int]]): Long = roads
    ./:(Map.empty[Int, Int].withDefaultValue(0)) { case (graph, Array(i, j)) => graph.updated(i, graph(i) + 1).updated(j, graph(j) + 1) }
    .toSeq
    .sortBy { case (_, degree) => -degree }
    .zip(n to 1 by -1)
    .map { case ((_, degree), weight) => weight * degree.toLong }
    .sum
}
